@echo #######################################################################
@echo ##                 输入工程要设置的版本号						 ##
@echo #######################################################################
@echo.



:: 此处需要设置或修改MAVEN_OPTS，否则在执行mvn install命令时可能会出现OutOfMemoryError错误
:: 等号后面不能加引号
@set MAVEN_OPTS=-Xmx128m -XX:MaxPermSize=128m


@call mvn versions:set

del *.versionsBackup /f /s /q /a


@echo.
@echo 按任意键退出…… & pause>nul