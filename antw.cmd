'@echo off'
parse arg mode envarg '::' antarg

if mode\='.' & mode\='..' & mode\='/' then do
  envarg = mode envarg
  mode = ''
end

if antarg = '' then do
  antarg = envarg
  envarg = ''
end

x = setlocal()

env="OS2ENVIRONMENT"
antenv = _getenv_('antenv')
if _testenv_() = 0 then interpret 'call "' || antenv || '"' '"' || envarg || '"'

if mode = '' then mode = _getenv_('ANT_MODE' '..')
if mode \= '/' then do
  runrc = _getenv_('runrc')
  antrc = _getenv_('antrc' 'antrc.cmd')
  if mode = '..' then mode = '-r'
  else mode = ''
  interpret 'call "' || runrc || '"' antrc '"' || mode || '"'
end

if _testenv_() = 0 then do
  say 'Ant environment is not set properly'
  x = endlocal()
  exit 16
end

settings = '-Dant.home=' || ANT_HOME '-Djava.home=' || JAVA_HOME

java = _getenv_('javacmd' 'java')
opts = value('ANT_OPTS',,env)
args = value('ANT_ARGS',,env)
lcp = value('LOCALCLASSPATH',,env)
cp = value('CLASSPATH',,env)
if value('ANT_USE_CP',,env) \= '' then do
  if lcp \= '' & right(lcp, 1) \= ';' then lcp = lcp || ';'
  lcp = lcp || cp
  'SET CLASSPATH='
end
if lcp\='' then lcp = '-classpath' lcp

cmd = java opts lcp '-jar' ANT_HOME ||'\lib\ant-launcher.jar' settings args antarg
launcher = stream(ANT_HOME ||'\lib\ant-launcher.jar', 'C', 'query exists')
if launcher = '' then entry = 'com.rimerosolutions.ant.wrapper.AntWrapperMain'
else entry = 'com.rimerosolutions.ant.wrapper.AntWrapperMain'
java opts lcp entry settings args antarg

x = endlocal()

return rc

_testenv_: procedure expose env ANT_HOME JAVA_HOME
ANT_HOME = value('ANT_HOME',,env)
if ANT_HOME = '' then return 0
JAVA_HOME = value('JAVA_HOME',,env)
if JAVA_HOME = '' then return 0
cp = translate(value('CLASSPATH',,env))
if pos(translate(ANT_HOME), cp) = 0 then return 0
if pos(translate(JAVA_HOME), cp) = 0 then return 0
return 1

_getenv_: procedure expose env
parse arg envar default
if default = '' then default = envar
var = value(translate(envar),,env)
if var = '' then var = default
return var
