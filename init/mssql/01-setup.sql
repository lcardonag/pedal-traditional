-- SQL Server setup for pedal-traditional (employees datasource)
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'pedal')
BEGIN
    CREATE DATABASE pedal;
END
GO

USE pedal;
GO

IF NOT EXISTS (SELECT name FROM sys.server_principals WHERE name = N'admin')
BEGIN
    CREATE LOGIN admin WITH PASSWORD = 'admin1', CHECK_POLICY = OFF;
END
GO

IF NOT EXISTS (SELECT name FROM sys.database_principals WHERE name = N'admin')
BEGIN
    CREATE USER admin FOR LOGIN admin;
    ALTER ROLE db_owner ADD MEMBER admin;
END
GO

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = N'employees')
BEGIN
    CREATE TABLE employees (
        id bigint IDENTITY(1,1) PRIMARY KEY,
        fullname varchar(255),
        username varchar(255),
        email varchar(255),
        date_created datetime2,
        password varchar(255),
        user_role varchar(255)
    );
END
GO
