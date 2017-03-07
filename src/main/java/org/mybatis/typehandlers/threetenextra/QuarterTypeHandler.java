/**
 *    Copyright 2016-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.typehandlers.threetenextra;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.threeten.extra.Quarter;

/**
 * Type Handler for threeten-extra Quarter
 * 
 * @author Björn Raupach
 */
public class QuarterTypeHandler extends BaseTypeHandler<Quarter> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, Quarter quarter, JdbcType type) throws SQLException {
        ps.setString(parameterIndex, quarter.name());
    }

    @Override
    public Quarter getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String str = rs.getString(columnName);
        return getQuarter(str);
    }

    @Override
    public Quarter getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String str = rs.getString(columnIndex);
        return getQuarter(str);
    }

    @Override
    public Quarter getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String str = cs.getString(columnIndex);
        return getQuarter(str);
    }
    
    private static Quarter getQuarter(String str) {
        if (str != null) {
            return Quarter.valueOf(str);
        }
        return null;
    }
    
}
