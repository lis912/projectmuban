package com.lishichang.service;

import javax.swing.*;


/**
 *  全局参数 GlobalVar 控制导入和导出配置
 */
public class GlobalVar {
   // public static String ExportPath = ".\\outdoc\\";   // 这个写法也可以
    public static String ExportPath = "./outdoc/";
    public static String MyWorkPath = "./我的调研表/";
    public static String TemplatePath = "./template/";

    // 输出文档选择变量
    public static boolean GENERAL = false;
    public static boolean NONETWORK = false;
    public static boolean SCANHOSTS = false;
    public static boolean SCANWEB = false;
    public static boolean WORDCHANGE = false;
    public static boolean PROJECTPLAN = false;
    public static boolean SIGN = false;

    // 问题汇总选择变量
    public static boolean PROBLEMGENERAL = false;
    public static boolean PROBLEMNONETWORK = false;
    public static boolean PROBLEMDEVIP = false;
    public static boolean ASSOCIATEDHSLIST = false;
    public static boolean RECTIFICATIONSCHEME = false;

    // 输入文档选择变量
    public static boolean BoxOnePlat = false;
    public static boolean BoxTwoPhy = false;
    public static boolean BoxThrNet = false;
    public static boolean BoxFourSec = false;
    public static boolean BoxFiveCip = false;
    public static boolean BoxSixHost = false;
    public static boolean BoxSevTerm = false;
    public static boolean BoxEigTerm = false;
    public static boolean BoxNineApp = false;
    public static boolean BoxTenData = false;
    public static boolean BoxElePer = false;
    public static boolean BoxTweDoc = false;
    public static boolean BoxThirTopology = false;
    public static boolean BoxFoteCloud = false;

    /**
     *  isNoSelectImport 是否未选择导入表
     * @return true  未选
     * @return false  至少选了一个
     */
  public static boolean isNoSelectImport(){
       if(BoxOnePlat || BoxTwoPhy || BoxThrNet || BoxFourSec || BoxFiveCip || BoxSixHost || BoxSevTerm ||
           BoxEigTerm || BoxNineApp || BoxTenData || BoxElePer || BoxTweDoc || BoxThirTopology || BoxFoteCloud){
          return false;
      }
          return true;
   }

    /**
     *  isNoSelectExport 是否未选择导出内容
     * @return true  未选
     * @return false  至少选了一个
     */
    public static boolean isNoSelectExport(){
      if(GENERAL || NONETWORK || SCANHOSTS || SCANWEB || WORDCHANGE || SIGN || PROJECTPLAN){
         return false;
      }
      return true;
    }

    /**
     *  isNoSelectExport 是否未选择问题汇总导出页面
     * @return true  未选
     * @return false  至少选了一个
     */
    public static boolean isNoSelectProblemExport(){
        if(PROBLEMGENERAL || PROBLEMNONETWORK || PROBLEMDEVIP || ASSOCIATEDHSLIST || RECTIFICATIONSCHEME){
            return false;
        }
        return true;
    }
}
