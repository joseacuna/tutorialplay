package models.Hibernate;

import org.apache.commons.lang.StringUtils;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.util.StringHelper;
import play.Play;

import java.util.Collections;
import java.util.Set;

/**
 * @author  by claudio on 10-10-15.
 */
public class AppImprovedNamingStrategy extends ImprovedNamingStrategy {

    @Override
    public String classToTableName(String className) {
        String tableName = super.classToTableName(className);
        if (getExludedPrefixSet().contains(StringHelper.unqualify(className))) {
            return tableName;
        }
        return addPrefix(tableName);
    }

    @Override
    public String tableName(String tableName) {
        String newTableName = super.tableName(tableName);
        if (getExcludedPrefixTablesSet().contains(newTableName)) {
            return newTableName;
        }
        return addPrefix(newTableName);
    }

    protected static String addPrefix(String tableName) {
        String prefix = Play.configuration.getProperty("application.tablename.prefix");
        return StringUtils.isNotEmpty(prefix) && !tableName.startsWith(prefix) ? prefix + tableName : tableName;
    }

    private static Set<String> excludedPrefixSet;
    private static Set<String> excludedPrefixTablesSet;

    protected static Set<String> getExludedPrefixSet() {

        return Collections.emptySet();
    }

    protected static Set<String> getExcludedPrefixTablesSet() {

        return Collections.emptySet();
    }


    /**
     * Le agrega el prefijo "id_" a las columnas foreign keys
     * @param propertyName
     * @param propertyEntityName
     * @param propertyTableName
     * @param referencedColumnName
     * @return
     */
    @Override
    public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
        String name = super.foreignKeyColumnName(propertyName, propertyEntityName, propertyTableName, referencedColumnName);
        return name.startsWith("id_")? name : "id_" + name;
    }
}
