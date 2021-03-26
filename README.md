## 测评项目文档生成工具(工作辅助)
该工具是一个word模板替换工具，从固定excel表格读取数据到本地数据库，然后重新组织替换word模板导出工具。

* 实现了多个工作模板文件的自动输出，包括
    - [x] 测评方案
    - [x] 项目计划书
	- [x] 工具测试指导书
    - [x] 问题汇总
	- [x] 文档交接单
    - [x] 启动资料生成
    - [x] 项目其他流程资料

* 使用Swing和SQLite数据库，无需额外配置数据库
* Entity层、DAO层、Service层和GUI层分离，GUI层界面、数据、监听器分离
* 面板使用单例模式，数据库采用外键约束
* 带有详细的注释

## 启动
入口为
```
startup.Bootstrap.main
```

## 演示
![](https://github.com/lis912/projectmuban/blob/master/sample.jpg)
## 目录结构

```
├─db		数据库										
│      Ceping.db
│      sqlite3.exe
│      建表语句.sql
│
├─lib		依赖
│      chart.jar
│      pgslookandfeel-1.1.2.jar
│      sqlite-jdbc-3.20.0.jar
│      swingx-core-1.6.2.jar
│
├─outdoc	工具输出目录
├─src
│  ├─main
│  │  └─java
│  │      ├─com
│  │      │  └─lishichang
│  │      │      ├─dao		dao层
│  │      │      │      AppInfNineDAO.java
│  │      │      │      CleanTableDAO.java
│  │      │      │      CloudinFourteenDAO.java
│  │      │      │      DocumentTwelveDAO.java
│  │      │      │      HostInfSixDAO.java
│  │      │      │      JobElevenDAO.java
│  │      │      │      NetDeviceThreeDAO.java
│  │      │      │      PlatInfOneDAO.java
│  │      │      │      ProblemDAO.java
│  │      │      │      PsychzInfTwoDAO.java
│  │      │      │      SecurityDevFourDAO.java
│  │      │      │      TerminalSevenDAO.java
│  │      │      │      TmpProblemDAO.java
│  │      │      │      TopologyThirteenDAO.java
│  │      │      │
│  │      │      ├─entity	实体类
│  │      │      │      AppInfNine.java
│  │      │      │      Archived.java
│  │      │      │      CloudinFourteen.java
│  │      │      │      DocumentTwelve.java
│  │      │      │      HostInfSix.java
│  │      │      │      JobEleven.java
│  │      │      │      NetDeviceThree.java
│  │      │      │      PlatInfOne.java
│  │      │      │      Problem.java
│  │      │      │      PsychzInfTwo.java
│  │      │      │      SecurityDevFour.java
│  │      │      │      TerminalSeven.java
│  │      │      │      TmpProblem.java
│  │      │      │      TopologyThirteen.java
│  │      │      │
│  │      │      ├─gui	UI界面
│  │      │      │  ├─frame
│  │      │      │  │      MainFrame.java
│  │      │      │  │
│  │      │      │  ├─listener
│  │      │      │  │      ArchiveCheckBoxListener.java
│  │      │      │  │      ArchiveListener.java
│  │      │      │  │      NewProListener.java
│  │      │      │  │      ProblemListener.java
│  │      │      │  │      ToolBarListener.java
│  │      │      │  │
│  │      │      │  ├─model
│  │      │      │  ├─panel
│  │      │      │  │      ArchivedPanel.java
│  │      │      │  │      MainPanel.java
│  │      │      │  │      NewProPanel.java
│  │      │      │  │      ProblemPanel.java
│  │      │      │  │      SummaryinfoPanel.java
│  │      │      │  │      WorkingPanel.java
│  │      │      │  │
│  │      │      │  └─util
│  │      │      │          CenterPanel.java
│  │      │      │          ColorUtil.java
│  │      │      │          DBUtil.java
│  │      │      │          GUIUtil.java
│  │      │      │          ReadWriteUtil.java
│  │      │      │
│  │      │      ├─mubanentity		word模板数据类
│  │      │      │      App.java
│  │      │      │      Cloudinf.java
│  │      │      │      Document.java
│  │      │      │      Host.java
│  │      │      │      Job.java
│  │      │      │      ListHost.java
│  │      │      │      ListNetDevice.java
│  │      │      │      ListSignDevIP.java
│  │      │      │      NetDevice.java
│  │      │      │      NewPro.java
│  │      │      │      PenetraApp.java
│  │      │      │      Psychz.java
│  │      │      │      SafeManageCenter.java
│  │      │      │      SAGlevel.java
│  │      │      │      ScanApp.java
│  │      │      │      ScanHost.java
│  │      │      │      ScanHostIP.java
│  │      │      │      SecurityDevice.java
│  │      │      │      SignDevIP.java
│  │      │      │      SummaryProblem.java
│  │      │      │      Terminal.java
│  │      │      │      WordChange.java
│  │      │      │
│  │      │      ├─service	业务逻辑
│  │      │      │      ExportFangAn.java
│  │      │      │      ExportNewPro.java
│  │      │      │      ExportProjectPlan.java
│  │      │      │      ExportSignOff.java
│  │      │      │      ExportSummaryProblem.java
│  │      │      │      ExportToolTestHost.java
│  │      │      │      ExportToolTestWeb.java
│  │      │      │      ExportWordChange.java
│  │      │      │      GlobalVar.java
│  │      │      │      ReadExceltoDB.java
│  │      │      │      ReadProblemSourcetoDB.java
│  │      │      │      ReadTmpProblemSourcetoDB.java
│  │      │      │
│  │      │      ├─startup	启动类
│  │      │             Bootstrap.java
│  │      │      
│  └─test		测试
│      └─java
│          └─com
│              └─lishichang
│                      AppTest.java
│                      JCheckBoxExample.java
│
├─template			word模板文件
│      WEB工具测试指导书v1.docx
│      临时网络拓扑图.png
│      入场离场确认v1纸张纵向模板.docx
│      工具测试指导书模板v1.docx
│      文档交接单模板v1.docx
│      测评工具清单v1.1.docx
│      等保2安全问题汇总.xlsx
│      等级测评方案模板1.2-无网络B.docx
│      等级测评方案模板1.2-通用A.docx
│      问题汇总-无网络模板.docx
│      问题汇总-通用模板.docx
│      问题汇总模板.docx
│      项目启动资料模板.docx
│      项目计划书模板v1.docx
│
└─我的调研表		excel模板
        XXX系统-网络安全等级测评调研表模板.xlsx
```


## 数据库结构
db/Ceping.db已经包含了完整的数据结构和测试数据，每次导入都会清理上一次历史数据，重置ID。
```sqlite
CREATE TABLE "platinfone"  ( 
	"pid"  	INTEGER ,
	"platname"	VARCHAR(255) PRIMARY KEY NOT NULL,
	"protectclass"	VARCHAR(255) NOT NULL,
	"number"	VARCHAR(255), 
	"describe"	TEXT,
	"organname"	VARCHAR(255) NOT NULL,
	"organaddr"	VARCHAR(255),
	"postnum"	VARCHAR(255),
	"principal"	VARCHAR(255),
	"department" VARCHAR(255),
	"job" VARCHAR(255),
	"telnum" VARCHAR(255),
	"phonenum" VARCHAR(255),
	"mail" VARCHAR(255)
)

CREATE TABLE "psychzinftwo"  ( 
	"psychzid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"pplatname" VARCHAR(255) CONSTRAINT fk_psychzinftwo_platinfone REFERENCES platinfone (platname),	
	"PsychzName"	VARCHAR(255) NOT NULL,
	"PsychzAddr"	VARCHAR(255) NOT NULL,
	"PsychzDegree"	VARCHAR(255) NOT NULL, 
	"PisSample"	VARCHAR(255)
)

CREATE TABLE "netinfthree"  ( 
	"Nid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"NplatName" VARCHAR(255) CONSTRAINT fk_netinfthree_platinfone REFERENCES platinfone (platname),
	"NdeviceName"	VARCHAR(255) NOT NULL,
	"NisVMhost"	VARCHAR(255),
	"NosName"	VARCHAR(255), 
	"Nmodel"	VARCHAR(255),
	"Ndescribe"	VARCHAR(255),
	"NipAddr"	VARCHAR(255) NOT NULL,
	"Namount"	VARCHAR(255)  NOT NULL,
	"NDegree" VARCHAR(255)  NOT NULL,
	"NisSample" VARCHAR(255)  NOT NULL
)



CREATE TABLE "securitydevfour"  ( 
	"sid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"splatName" VARCHAR(255) CONSTRAINT fk_securitydevfour_platinfone REFERENCES platinfone (platname),
	"sdeviceName"	VARCHAR(255) NOT NULL,
	"sisVMhost"	VARCHAR(255),
	"sosName"	VARCHAR(255), 
	"smodel"	VARCHAR(255),
	"sdescribe"	VARCHAR(255),
	"sipAddr"	VARCHAR(255) NOT NULL,
	"samount"	VARCHAR(255)  NOT NULL,
	"sDegree" VARCHAR(255)  NOT NULL,
	"sisSample" VARCHAR(255)  NOT NULL
)




CREATE TABLE "hostinfsix"  ( 
	"hostid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"fplatname" VARCHAR(255) CONSTRAINT fk_hostinfsix_platinfone REFERENCES platinfone (platname),
	"hostname"	VARCHAR(255) NOT NULL,
	"appsystemname"	VARCHAR(255) NOT NULL,
	"isvmhost"	VARCHAR(255) NOT NULL, 
	"area"	VARCHAR(255),
	"osname"	VARCHAR(255) NOT NULL,
	"dataosname"	VARCHAR(255) NOT NULL,
	"bitname"	VARCHAR(255)  NOT NULL,
	"amount"	VARCHAR(255)  NOT NULL,
	"ipsddr" VARCHAR(255)  NOT NULL,
	"hostdegree" VARCHAR(255)  NOT NULL,
	"issample" VARCHAR(255)  NOT NULL
)


CREATE TABLE "terminalseven"  ( 
	"tid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"tplatName" VARCHAR(255) CONSTRAINT fk_terminalseven_platinfone REFERENCES platinfone (platname),
	"tdeviceName"	VARCHAR(255),
	"tisVMhost"	VARCHAR(255),
	"tosName"	VARCHAR(255), 
	"tmodel"	VARCHAR(255),
	"tdescribe"	VARCHAR(255),
	"tipAddr"	VARCHAR(255),
	"tamount"	VARCHAR(255),
	"tDegree" VARCHAR(255),
	"tisSample" VARCHAR(255)
)


CREATE TABLE "appinfnine"  ( 
	"aid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"aplatName" VARCHAR(255) CONSTRAINT fk_appinfnine_platinfone REFERENCES platinfone (platname),
	"appName"	VARCHAR(255),
	"aFunction"	VARCHAR(255),
	"aVersion"	VARCHAR(255), 
	"aDevelopName"	VARCHAR(255),
	"architecture"	VARCHAR(255),
	"aurl"	VARCHAR(255),
	"aDegree"	VARCHAR(255),
	"aisSample" VARCHAR(255)
)


CREATE TABLE "jobeleven"  ( 
	"jId"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"jpaltName" VARCHAR(255) CONSTRAINT fk_jobeleven_platinfone REFERENCES platinfone (platname),
	"jName"	VARCHAR(255),
	"jobName"	VARCHAR(255),
	"jphone" VARCHAR(255)
)

CREATE TABLE "documenttwelve"  ( 
	"dId"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"dpaltName" VARCHAR(255) CONSTRAINT fk_documenttwelve_platinfone REFERENCES platinfone (platname),
	"documenName"	VARCHAR(255),
	"details"	VARCHAR(255)
)

CREATE TABLE "topologythirteen"  ( 
	"tpid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ,
	"tpaltName"	VARCHAR(255) CONSTRAINT fk_topologythirteen_platinfone REFERENCES platinfone (platname),
	"tPathName"	VARCHAR(255),
	"tNetworkDescription"	TEXT
)

CREATE TABLE "cloudinfofourteen"  ( 
	"cid"  	INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
	"cpaltName" VARCHAR(255) CONSTRAINT fk_cloudinfofourteen_platinfone REFERENCES platinfone (platname),
	"cloudPlatName"	VARCHAR(255),
	"cloudLesseeName"	VARCHAR(255),
	"cloudServerDetail"	VARCHAR(255)
)



CREATE TABLE "Problem"  ( 
	"Proid"  	INTEGER,
	"proBigLay"	VARCHAR(255), 
	"proMinLay"	VARCHAR(255),
	"proPoint"	VARCHAR(255), 
	"proItem"	VARCHAR(255) PRIMARY KEY NOT NULL,
	"proItemDegree"	VARCHAR(255),
	"proDescribe"	VARCHAR(255),
	"proAnalyse"	TEXT,
	"proaThret"	VARCHAR(255),
	"proaThretDegree" VARCHAR(255),
	"proaThretAnalyse" TEXT,
	"proaRecommendations" TEXT,
	"proDev" VARCHAR(255),
	"proComment" VARCHAR(255)
)

CREATE TABLE "Problem"  ( 
	"Proid"  	INTEGER,
	"proBigLay"	VARCHAR(255), 
	"proMinLay"	VARCHAR(255),
	"proPoint"	VARCHAR(255), 
	"proItem"	VARCHAR(255),
	"proItemDegree"	VARCHAR(255),
	"proDescribe"	VARCHAR(255),
	"proAnalyse"	TEXT,
	"proaThret"	VARCHAR(255),
	"proaThretDegree" VARCHAR(255),
	"proaThretAnalyse" TEXT,
	"proaRecommendations" TEXT,
	"proDev" VARCHAR(255),
	"proComment" VARCHAR(255),
	PRIMARY KEY(proMinLay,proItem)
)

CREATE TABLE "ProblemforNet"  ( 
	"Proid"  	INTEGER,
	"proBigLay"	VARCHAR(255), 
	"proMinLay"	VARCHAR(255),
	"proPoint"	VARCHAR(255), 
	"proItem"	VARCHAR(255) PRIMARY KEY NOT NULL,
	"proItemDegree"	VARCHAR(255),
	"proDescribe"	VARCHAR(255),
	"proAnalyse"	TEXT,
	"proaThret"	VARCHAR(255),
	"proaThretDegree" VARCHAR(255),
	"proaThretAnalyse" TEXT,
	"proaRecommendations" TEXT,
	"proDev" VARCHAR(255),
	"proComment" VARCHAR(255)
)


CREATE TABLE "ProblemforNet"  ( 
	"Proid"  	INTEGER,
	"proBigLay"	VARCHAR(255), 
	"proMinLay"	VARCHAR(255),
	"proPoint"	VARCHAR(255), 
	"proItem"	VARCHAR(255),
	"proItemDegree"	VARCHAR(255),
	"proDescribe"	VARCHAR(255),
	"proAnalyse"	TEXT,
	"proaThret"	VARCHAR(255),
	"proaThretDegree" VARCHAR(255),
	"proaThretAnalyse" TEXT,
	"proaRecommendations" TEXT,
	"proDev" VARCHAR(255),
	"proComment" VARCHAR(255),
	PRIMARY KEY(proMinLay,proItem)
)
 
CREATE TABLE "TmpProblem"  ( 
	"tmpid"  	INTEGER,
	"tmpAssociateDev"	VARCHAR(255), 
	"tmpBigLay"	VARCHAR(255),
	"tmpItem"	VARCHAR(255) PRIMARY KEY NOT NULL
)

```

## 启动流程
```
startup.Bootstrap.main()            主类
↓
gui.panel.MainFrame.instance        程序窗体
├─gui.listener.ToolBarListener    	监控按钮操作
↓
gui.panel.MainPanel.instance        底层Panel及导航栏
↓
MainPanel.instance.workingPanel     功能Panel的底Panel，实现了居中的功能
↓
gui.panel.ArchivedPanel.instance    导入调研表界面
↓
gui.panel.*                         通过监控菜单栏实现其他Panel的切换
```

## License
   
GPL v3.0

