package com.hdsxtech.www.mvptestt.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者:丁文 on 2018/4/11.
 * copyright: www.hdsxtech.com
 */

public class MyNewsBean implements Serializable{

    /**
     * r : [{"createtime":"2018-04-04 12:11:05","messtatus":0,"id":"780843C5-BED9-4056-88A3-E3016BF61480","mescontent":"null","mesname":"【十九大 理论新视野】社会主要矛盾转化与健全人民当家作主制度体系","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=0D2BD4A3-CB61-4E97-A0B5-02683D225EA1"},{"createtime":"2018-04-04 11:37:16","messtatus":1,"id":"796D348F-A613-4E4F-84A6-00D656FB79FC","mescontent":"null","mesname":"黑客入侵选号系统","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=81DDED55-4242-4EA6-BF9B-B9A83E098F46"},{"createtime":"2018-04-04 11:28:58","messtatus":0,"id":"2F22BABA-D510-467D-B530-CDFB93BA2298","mescontent":"您有一条通知通告：【十九大 理论新视野】社会主要矛盾转化与健全人民当家作主制度体系,请在综合工作->通知通告 查看。","mesname":"【十九大 理论新视野】社会主要矛盾转化与健全人民当家作主制度体系","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=B3A45B63-FCE7-4C5F-B403-EEF842673471"},{"createtime":"2018-01-18 15:30:04","messtatus":1,"id":"5B1258B5-8255-4146-BFC4-677493E7A3DF","mescontent":"您提交审批的\"1\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=5B1258B5-8255-4146-BFC4-677493E7A3DF"},{"createtime":"2018-01-18 15:23:07","messtatus":1,"id":"5BFFBD67-D7E3-45C5-9132-FB5373B5BFC2","mescontent":"您提交审批的\"1\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=5BFFBD67-D7E3-45C5-9132-FB5373B5BFC2"},{"createtime":"2018-01-18 15:16:35","messtatus":1,"id":"D1770B7C-DB24-4994-8457-4C34C582AD93","mescontent":"您提交审批的\"蟹岛封闭开发\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=D1770B7C-DB24-4994-8457-4C34C582AD93"},{"createtime":"2018-01-18 15:02:02","messtatus":1,"id":"5F26BB66-8282-4F81-B485-67198B83D523","mescontent":"您提交审批的\"蟹岛封闭开发\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=5F26BB66-8282-4F81-B485-67198B83D523"},{"createtime":"2018-01-15 16:22:05","messtatus":0,"id":"7D20B5BF-927B-4F6C-BF6B-C591C1FF6AF4","mescontent":"您提交审批的\"1\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=7D20B5BF-927B-4F6C-BF6B-C591C1FF6AF4"},{"createtime":"2018-01-15 14:55:00","messtatus":0,"id":"D35E5922-1B93-49CC-93B2-0DBE11E4666A","mescontent":"您提交审批的\"蟹岛封闭开发\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=D35E5922-1B93-49CC-93B2-0DBE11E4666A"},{"createtime":"2018-01-15 14:45:40","messtatus":0,"id":"BBE9C31F-911B-494F-B39E-AA0DA7654D76","mescontent":"您提交审批的\"1\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=BBE9C31F-911B-494F-B39E-AA0DA7654D76"},{"createtime":"2018-01-15 14:09:16","messtatus":1,"id":"919375CC-4EFA-43C1-9640-E1DFCA84EC48","mescontent":"您提交审批的\"1\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=919375CC-4EFA-43C1-9640-E1DFCA84EC48"},{"createtime":"2018-01-02 15:47:52","messtatus":0,"id":"A2F054AC-43E1-41AF-920F-371AD53C498C","mescontent":"您有一条通知通告：交通运输部新一批党员的转正通知,请在综合工作->通知通告 查看。","mesname":"交通运输部新一批党员的转正通知","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=D7BC8533-0155-44CD-80CA-D47AF55FB0C1"},{"createtime":"2018-01-02 15:21:28","messtatus":0,"id":"9F77FADC-B2B3-4AE8-A4DB-E5EE3FFE8792","mescontent":"您有一条通知通告：交干院团委举办\u201c践行三严三实为团旗增辉\u201d主题团日活动,请在综合工作->通知通告 查看。","mesname":"交干院团委举办\u201c践行三严三实为团旗增辉\u201d主题团日活动","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=12864A14-1D30-47F6-B8D8-45C21DD920D8"},{"createtime":"2018-01-01 20:22:42","messtatus":1,"id":"DA1D9A8E-179D-458A-96E1-0978F6E2D6B8","mescontent":"null","mesname":"关于转发《交通运输部关于加强和改进交通运输标准化工作的意见》的通知 ","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=328809F4-D2D9-4848-AF2E-C4AFB366B232"},{"createtime":"2018-01-01 16:02:19","messtatus":1,"id":"21DEBE60-3550-4666-B5FE-1537A7132AF9","mescontent":"您有一条通知通告：关于转发《交通运输部关于加强和改进交通运输标准化工作的意见》的通知 ,请在综合工作->通知通告 查看。","mesname":"关于转发《交通运输部关于加强和改进交通运输标准化工作的意见》的通知 ","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=C242BEDF-B690-4DFE-93C3-CA3D245031E1"},{"createtime":"2017-12-27 17:44:35","messtatus":1,"id":"39263B53-4C4C-4650-8271-DA3B25C4A82F","mescontent":"一条重要通知通告，已经发布，请登录党建工作管理系统查看。","mesname":"测试通知通告邮件","mestype":14,"url":"http://192.168.166.1:9081/djweb/notice-content?id=575A3048-EDF1-4D3E-8ED0-0F93A41941A0"},{"createtime":"2017-12-27 10:03:57","messtatus":1,"id":"401C468D-EC8B-41B2-85CD-3089A42786F1","mescontent":"您提交审批的\"111\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=401C468D-EC8B-41B2-85CD-3089A42786F1"},{"createtime":"2017-12-27 09:56:20","messtatus":1,"id":"EF09B57F-AF05-43B7-8F52-F0C6E41A8EB9","mescontent":"您提交审批的\"111\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=EF09B57F-AF05-43B7-8F52-F0C6E41A8EB9"},{"createtime":"2017-12-27 09:51:54","messtatus":0,"id":"5F107F88-E153-42BC-A8CD-37008FBADB3C","mescontent":"您提交审批的\"111\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=5F107F88-E153-42BC-A8CD-37008FBADB3C"},{"createtime":"2017-12-27 09:48:46","messtatus":0,"id":"1427E7D4-E9A3-44BF-A85B-38B491A0328D","mescontent":"您提交审批的\"111\"已审批通过，具体详情请在相关业务模块中查阅。","mesname":"报送内容提交前审批状态提醒通知","mestype":15,"url":"http://192.168.166.1:9081/djweb/message-detail?id=1427E7D4-E9A3-44BF-A85B-38B491A0328D"}]
     * c : 1
     * m : 查询成功
     */

    private int c;
    private String m;
    private List<RBean> r;

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public List<RBean> getR() {
        return r;
    }

    public void setR(List<RBean> r) {
        this.r = r;
    }

    public static class RBean {
        /**
         * createtime : 2018-04-04 12:11:05
         * messtatus : 0
         * id : 780843C5-BED9-4056-88A3-E3016BF61480
         * mescontent : null
         * mesname : 【十九大 理论新视野】社会主要矛盾转化与健全人民当家作主制度体系
         * mestype : 14
         * url : http://192.168.166.1:9081/djweb/notice-content?id=0D2BD4A3-CB61-4E97-A0B5-02683D225EA1
         */

        private String createtime;
        private int messtatus;
        private String id;
        private String mescontent;
        private String mesname;
        private int mestype;
        private String url;

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public int getMesstatus() {
            return messtatus;
        }

        public void setMesstatus(int messtatus) {
            this.messtatus = messtatus;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMescontent() {
            return mescontent;
        }

        public void setMescontent(String mescontent) {
            this.mescontent = mescontent;
        }

        public String getMesname() {
            return mesname;
        }

        public void setMesname(String mesname) {
            this.mesname = mesname;
        }

        public int getMestype() {
            return mestype;
        }

        public void setMestype(int mestype) {
            this.mestype = mestype;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
