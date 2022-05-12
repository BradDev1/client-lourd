/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javacrud.model;

/**
 *
 * @author b.chesneau
 */
public class Configuration {
    private String mailProtocol;
    private String mailHost;
    private String mailPort;
    private String mailUser;
    private String mailPass;
    private String mysqlHost;
    private String mysqlPort;
    private String mysqlDb;
    private String mysqlUser;
    private String mysqlPass;

    public Configuration() {
    }

    public String getMailProtocol() {
        return mailProtocol;
    }

    public void setMailProtocol(String mailProtocol) {
        this.mailProtocol = mailProtocol;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getMailPort() {
        return mailPort;
    }

    public void setMailPort(String mailPort) {
        this.mailPort = mailPort;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getMailPass() {
        return mailPass;
    }

    public void setMailPass(String mailPass) {
        this.mailPass = mailPass;
    }

    public String getMysqlHost() {
        return mysqlHost;
    }

    public void setMysqlHost(String mysqlHost) {
        this.mysqlHost = mysqlHost;
    }

    public String getMysqlPort() {
        return mysqlPort;
    }

    public void setMysqlPort(String mysqlPort) {
        this.mysqlPort = mysqlPort;
    }

    public String getMysqlDb() {
        return mysqlDb;
    }

    public void setMysqlDb(String mysqlDb) {
        this.mysqlDb = mysqlDb;
    }

    public String getMysqlUser() {
        return mysqlUser;
    }

    public void setMysqlUser(String mysqlUser) {
        this.mysqlUser = mysqlUser;
    }

    public String getMysqlPass() {
        return mysqlPass;
    }

    public void setMysqlPass(String mysqlPass) {
        this.mysqlPass = mysqlPass;
    }
    
}
