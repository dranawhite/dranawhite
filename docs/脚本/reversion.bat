@echo #######################################################################
@echo ##                 ���빤��Ҫ���õİ汾��						 ##
@echo #######################################################################
@echo.



:: �˴���Ҫ���û��޸�MAVEN_OPTS��������ִ��mvn install����ʱ���ܻ����OutOfMemoryError����
:: �Ⱥź��治�ܼ�����
@set MAVEN_OPTS=-Xmx128m -XX:MaxPermSize=128m


@call mvn versions:set

del *.versionsBackup /f /s /q /a


@echo.
@echo ��������˳����� & pause>nul