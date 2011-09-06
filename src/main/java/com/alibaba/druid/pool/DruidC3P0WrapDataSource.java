package com.alibaba.druid.pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class DruidC3P0WrapDataSource implements DataSource {

    private DruidDataSource dataSource;

    public DruidC3P0WrapDataSource(){
        dataSource = new DruidDataSource();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return dataSource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        dataSource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        dataSource.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return dataSource.getLoginTimeout();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        if (iface == DruidC3P0WrapDataSource.class) {
            return (T) this;
        }

        return dataSource.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        if (iface == DruidC3P0WrapDataSource.class) {
            return true;
        }

        return dataSource.isWrapperFor(iface);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return dataSource.getConnection(username, password);
    }

    public String getUser() {
        return dataSource.getUsername();
    }

    public void setUser(String user) {
        dataSource.setUsername(user);
    }

    public String getPassword() {
        return dataSource.getPassword();
    }

    public void setPassword(String password) {
        dataSource.setPassword(password);
    }

    public int getCheckoutTimeout() {
        return (int) dataSource.getMaxWait();
    }

    public void setCheckoutTimeout(int checkoutTimeout) {
        dataSource.setMaxWait(checkoutTimeout);
    }

    public boolean isAutoCommitOnClose() {
        return dataSource.isDefaultAutoCommit();
    }

    public void setAutoCommitOnClose(boolean autoCommitOnClose) {
        this.dataSource.setDefaultAutoCommit(autoCommitOnClose);
    }

    public int getIdleConnectionTestPeriod() {
        return (int) dataSource.getTimeBetweenEvictionRunsMillis();
    }

    public void setIdleConnectionTestPeriod(int idleConnectionTestPeriod) {
        dataSource.setTimeBetweenEvictionRunsMillis(idleConnectionTestPeriod);
    }

    public int getInitialPoolSize() {
        return dataSource.getInitialSize();
    }

    public void setInitialPoolSize(int initialPoolSize) {
        dataSource.setInitialSize(initialPoolSize);
    }

    public int getMaxIdleTime() {
        return (int) dataSource.getMinEvictableIdleTimeMillis();
    }

    public void setMaxIdleTime(int maxIdleTime) {
        dataSource.setMinEvictableIdleTimeMillis(maxIdleTime);
    }

    public int getMaxPoolSize() {
        return dataSource.getMaxActive();
    }

    public void setMaxPoolSize(int maxPoolSize) {
        dataSource.setMaxActive(maxPoolSize);
    }

    public int getMinPoolSize() {
        return dataSource.getMinIdle();
    }

    public void setMinPoolSize(int minPoolSize) {
        dataSource.setMinIdle(minPoolSize);
    }

    public boolean isTestConnectionOnCheckout() {
        return dataSource.isTestOnBorrow();
    }

    public void setTestConnectionOnCheckout(boolean testConnectionOnCheckout) {
        dataSource.setTestOnBorrow(testConnectionOnCheckout);
    }

    public boolean isTestConnectionOnCheckin() {
        return dataSource.isTestOnReturn();
    }

    public void setTestConnectionOnCheckin(boolean testConnectionOnCheckin) {
        dataSource.setTestOnReturn(testConnectionOnCheckin);
    }

    public String getPreferredTestQuery() {
        return dataSource.getValidationQuery();
    }

    public void setPreferredTestQuery(String preferredTestQuery) {
        dataSource.setValidationQuery(preferredTestQuery);
    }

    // ///////////////

    private int     maxStatementsPerConnection;
    private String  overrideDefaultUser;
    private String  overrideDefaultPassword;
    private int     propertyCycle;
    private boolean breakAfterAcquireFailure;
    private boolean usesTraditionalReflectiveProxies;
    private String  userOverridesAsString;
    private int     maxAdministrativeTaskTime;
    private int     maxIdleTimeExcessConnections;
    private int     maxConnectionAge;
    private String  connectionCustomizerClassName;
    private int     unreturnedConnectionTimeout;
    private boolean debugUnreturnedConnectionStackTraces;
    private String  factoryClassLocation;
    private int     acquireIncrement = 1;
    private int     acquireRetryDelay;
    private int     acquireRetryAttempts;

    private String  connectionTesterClassName;
    private String  automaticTestTable;
    private int     maxStatements;

    public int getMaxStatements() {
        return maxStatements;
    }

    public void setMaxStatements(int maxStatements) {
        this.maxStatements = maxStatements;
    }

    public int getMaxStatementsPerConnection() {
        return maxStatementsPerConnection;
    }

    public void setMaxStatementsPerConnection(int maxStatementsPerConnection) {
        this.maxStatementsPerConnection = maxStatementsPerConnection;
    }

    public String getConnectionTesterClassName() {
        return connectionTesterClassName;
    }

    public void setConnectionTesterClassName(String connectionTesterClassName) {
        this.connectionTesterClassName = connectionTesterClassName;
    }

    public String getAutomaticTestTable() {
        return automaticTestTable;
    }

    public void setAutomaticTestTable(String automaticTestTable) {
        this.automaticTestTable = automaticTestTable;
    }

    private boolean forceIgnoreUnresolvedTransactions;

    public boolean isForceIgnoreUnresolvedTransactions() {
        return forceIgnoreUnresolvedTransactions;
    }

    public void setForceIgnoreUnresolvedTransactions(boolean forceIgnoreUnresolvedTransactions) {
        this.forceIgnoreUnresolvedTransactions = forceIgnoreUnresolvedTransactions;
    }

    public boolean isUsesTraditionalReflectiveProxies() {
        return usesTraditionalReflectiveProxies;
    }

    public void setUsesTraditionalReflectiveProxies(boolean usesTraditionalReflectiveProxies) {
        this.usesTraditionalReflectiveProxies = usesTraditionalReflectiveProxies;
    }

    public String getUserOverridesAsString() {
        return userOverridesAsString;
    }

    public void setUserOverridesAsString(String userOverridesAsString) {
        this.userOverridesAsString = userOverridesAsString;
    }

    public int getMaxAdministrativeTaskTime() {
        return maxAdministrativeTaskTime;
    }

    public void setMaxAdministrativeTaskTime(int maxAdministrativeTaskTime) {
        this.maxAdministrativeTaskTime = maxAdministrativeTaskTime;
    }

    public int getMaxIdleTimeExcessConnections() {
        return maxIdleTimeExcessConnections;
    }

    public void setMaxIdleTimeExcessConnections(int maxIdleTimeExcessConnections) {
        this.maxIdleTimeExcessConnections = maxIdleTimeExcessConnections;
    }

    public int getMaxConnectionAge() {
        return maxConnectionAge;
    }

    public void setMaxConnectionAge(int maxConnectionAge) {
        this.maxConnectionAge = maxConnectionAge;
    }

    public String getConnectionCustomizerClassName() {
        return connectionCustomizerClassName;
    }

    public void setConnectionCustomizerClassName(String connectionCustomizerClassName) {
        this.connectionCustomizerClassName = connectionCustomizerClassName;
    }

    public int getUnreturnedConnectionTimeout() {
        return unreturnedConnectionTimeout;
    }

    public void setUnreturnedConnectionTimeout(int unreturnedConnectionTimeout) {
        this.unreturnedConnectionTimeout = unreturnedConnectionTimeout;
    }

    public boolean isDebugUnreturnedConnectionStackTraces() {
        return debugUnreturnedConnectionStackTraces;
    }

    public void setDebugUnreturnedConnectionStackTraces(boolean debugUnreturnedConnectionStackTraces) {
        this.debugUnreturnedConnectionStackTraces = debugUnreturnedConnectionStackTraces;
    }

    public String getFactoryClassLocation() {
        return factoryClassLocation;
    }

    public void setFactoryClassLocation(String factoryClassLocation) {
        this.factoryClassLocation = factoryClassLocation;
    }

    public int getAcquireIncrement() {
        return acquireIncrement;
    }

    public void setAcquireIncrement(int acquireIncrement) {
        this.acquireIncrement = acquireIncrement;
    }

    public int getAcquireRetryAttempts() {
        return acquireRetryAttempts;
    }

    public void setAcquireRetryAttempts(int acquireRetryAttempts) {
        this.acquireRetryAttempts = acquireRetryAttempts;
    }

    public int getAcquireRetryDelay() {
        return acquireRetryDelay;
    }

    public void setAcquireRetryDelay(int acquireRetryDelay) {
        this.acquireRetryDelay = acquireRetryDelay;
    }

    public String getOverrideDefaultUser() {
        return overrideDefaultUser;
    }

    public void setOverrideDefaultUser(String overrideDefaultUser) {
        this.overrideDefaultUser = overrideDefaultUser;
    }

    public String getOverrideDefaultPassword() {
        return overrideDefaultPassword;
    }

    public void setOverrideDefaultPassword(String overrideDefaultPassword) {
        this.overrideDefaultPassword = overrideDefaultPassword;
    }

    public int getPropertyCycle() {
        return propertyCycle;
    }

    public void setPropertyCycle(int propertyCycle) {
        this.propertyCycle = propertyCycle;
    }

    public boolean isBreakAfterAcquireFailure() {
        return breakAfterAcquireFailure;
    }

    public void setBreakAfterAcquireFailure(boolean breakAfterAcquireFailure) {
        this.breakAfterAcquireFailure = breakAfterAcquireFailure;
    }

    // ////////////////

}