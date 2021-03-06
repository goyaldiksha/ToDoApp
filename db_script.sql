USE [ToDoApp]
GO
/****** Object:  Table [dbo].[session]    Script Date: 19/11/2020 1:38:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[session](
	[sessionId] [varchar](100) NULL,
	[userId] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[taskDetail]    Script Date: 19/11/2020 1:38:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[taskDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[uid] [int] NULL,
	[name] [varchar](50) NULL,
	[dueDate] [varchar](50) NULL,
	[completed] [bit] NULL,
 CONSTRAINT [PK_taskDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[userDetails]    Script Date: 19/11/2020 1:38:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[userDetails](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](15) NOT NULL,
	[email] [nchar](30) NOT NULL,
	[password] [nchar](20) NOT NULL,
 CONSTRAINT [PK_userDetails] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
