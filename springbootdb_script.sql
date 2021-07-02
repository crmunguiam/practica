USE [master]
GO
/****** Object:  Database [springbootdb]    Script Date: 01/07/2021 09:24:12 p. m. ******/
CREATE DATABASE [springbootdb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'springbootdb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\springbootdb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'springbootdb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\springbootdb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [springbootdb] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [springbootdb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [springbootdb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [springbootdb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [springbootdb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [springbootdb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [springbootdb] SET ARITHABORT OFF 
GO
ALTER DATABASE [springbootdb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [springbootdb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [springbootdb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [springbootdb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [springbootdb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [springbootdb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [springbootdb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [springbootdb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [springbootdb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [springbootdb] SET  DISABLE_BROKER 
GO
ALTER DATABASE [springbootdb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [springbootdb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [springbootdb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [springbootdb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [springbootdb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [springbootdb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [springbootdb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [springbootdb] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [springbootdb] SET  MULTI_USER 
GO
ALTER DATABASE [springbootdb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [springbootdb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [springbootdb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [springbootdb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [springbootdb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [springbootdb] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [springbootdb] SET QUERY_STORE = OFF
GO
USE [springbootdb]
GO
/****** Object:  Table [dbo].[tbl_users]    Script Date: 01/07/2021 09:24:12 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbl_users](
	[key_user] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[last_name] [varchar](50) NOT NULL,
	[surname] [varchar](50) NOT NULL,
	[rfc] [varchar](20) NOT NULL,
	[worshift] [varchar](2) NOT NULL,
	[gender] [varchar](2) NOT NULL,
	[phone] [varchar](20) NOT NULL,
	[pin] [varchar](10) NOT NULL,
	[birthdate] [date] NOT NULL,
 CONSTRAINT [PK_tbl_users] PRIMARY KEY CLUSTERED 
(
	[key_user] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tbl_users] ON 
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (10, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'1', N'5538475647', N'999988', CAST(N'2021-07-01' AS Date))
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (11, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'2', N'5538475647', N'9387202', CAST(N'2021-07-01' AS Date))
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (12, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'2', N'5538475647', N'9387202', CAST(N'2021-07-01' AS Date))
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (13, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'2', N'5538475647', N'9387202', CAST(N'2021-07-01' AS Date))
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (14, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'2', N'5538475647', N'9387202', CAST(N'2021-07-01' AS Date))
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (15, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'1', N'5538475647', N'999988', CAST(N'2021-07-01' AS Date))
GO
INSERT [dbo].[tbl_users] ([key_user], [name], [last_name], [surname], [rfc], [worshift], [gender], [phone], [pin], [birthdate]) VALUES (16, N'Diego Ivan', N'Hernandez', N'Martinez', N'GHTM920416CR6', N'1', N'1', N'5538475647', N'999988', CAST(N'2021-07-01' AS Date))
GO
SET IDENTITY_INSERT [dbo].[tbl_users] OFF
GO
USE [master]
GO
ALTER DATABASE [springbootdb] SET  READ_WRITE 
GO
