

建表语句：
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





# 内连接查询：以Problem为主表：
SELECT src.proDescribe, tmp.tmpAssociateDev, src.proItem, src.proaThretDegree,src.proaRecommendations
FROM Problem src
INNER JOIN TmpProblem tmp
ON src.proItem = tmp.tmpItem;


SELECT src.proDescribe, tmp.tmpAssociateDev
FROM Problem src
INNER JOIN TmpProblem tmp
ON src.proItem = tmp.tmpItem;

SELECT src.proDescribe, tmp.tmpAssociateDev, src.proItem, src.proaThretDegree,src.proaRecommendations
FROM Problem src
INNER JOIN TmpProblem tmp
ON src.proItem = tmp.tmpItem
where src.proDescribe != "无";

SELECT src.proDescribe, tmp.tmpAssociateDev, src.proItem, src.proaThretDegree,src.proaRecommendations
FROM Problem src
INNER JOIN TmpProblem tmp
ON src.proItem = tmp.tmpItem
where src.proDescribe != "无" and src.proMinLay == "安全计算环境";




SELECT src.proDescribe, tmp.tmpAssociateDev, src.proComment FROM Problem src INNER JOIN TmpProblem tmp ON src.proItem = tmp.tmpItem where src.proDescribe != "无" and src.proMinLay == "安全计算环境";



































