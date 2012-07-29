package org.es4j.persistence.sql.ollin;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

/**
 * <p>
 * A row view of the ResultSet.
 * </p>
 * All major row operations of the ResultSet are exposed through these view.
 *
 * @author Victor Hugo Herrera Maldonado
 */
public class ResultSetRow{
    private ResultSet rset;

    ResultSetRow(ResultSet rset) {
        this.rset = rset;
    }

    /**
     * Gets the ResultSet that is viewed through these object.
     * @return ResultSet
     */
    public ResultSet getResultSet() {
        return rset;
    }

    public boolean wasNull() throws SQLException {
        return rset.wasNull();
    }

    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        rset.updateTimestamp(columnLabel, x);
    }

    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        rset.updateTimestamp(columnIndex, x);
    }

    public void updateTime(String columnLabel, Time x) throws SQLException {
        rset.updateTime(columnLabel, x);
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
        rset.updateTime(columnIndex, x);
    }

    public void updateString(String columnLabel, String x) throws SQLException {
        rset.updateString(columnLabel, x);
    }

    public void updateString(int columnIndex, String x) throws SQLException {
        rset.updateString(columnIndex, x);
    }

    public void updateShort(String columnLabel, short x) throws SQLException {
        rset.updateShort(columnLabel, x);
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
        rset.updateShort(columnIndex, x);
    }

    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        rset.updateSQLXML(columnLabel, xmlObject);
    }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        rset.updateSQLXML(columnIndex, xmlObject);
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        rset.updateRowId(columnLabel, x);
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        rset.updateRowId(columnIndex, x);
    }

    public void updateRow() throws SQLException {
        rset.updateRow();
    }

    public void updateRef(String columnLabel, Ref x) throws SQLException {
        rset.updateRef(columnLabel, x);
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        rset.updateRef(columnIndex, x);
    }

    public void updateObject(String columnLabel, Object x) throws SQLException {
        rset.updateObject(columnLabel, x);
    }

    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        rset.updateObject(columnLabel, x, scaleOrLength);
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
        rset.updateObject(columnIndex, x);
    }

    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        rset.updateObject(columnIndex, x, scaleOrLength);
    }

    public void updateNull(String columnLabel) throws SQLException {
        rset.updateNull(columnLabel);
    }

    public void updateNull(int columnIndex) throws SQLException {
        rset.updateNull(columnIndex);
    }

    public void updateNString(String columnLabel, String nString) throws SQLException {
        rset.updateNString(columnLabel, nString);
    }

    public void updateNString(int columnIndex, String nString) throws SQLException {
        rset.updateNString(columnIndex, nString);
    }

    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        rset.updateNClob(columnLabel, reader);
    }

    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        rset.updateNClob(columnIndex, reader);
    }

    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        rset.updateNClob(columnLabel, reader, length);
    }

    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        rset.updateNClob(columnIndex, reader, length);
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        rset.updateNClob(columnLabel, nClob);
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        rset.updateNClob(columnIndex, nClob);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        rset.updateNCharacterStream(columnLabel, reader);
    }

    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        rset.updateNCharacterStream(columnIndex, x);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        rset.updateNCharacterStream(columnLabel, reader, length);
    }

    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        rset.updateNCharacterStream(columnIndex, x, length);
    }

    public void updateLong(String columnLabel, long x) throws SQLException {
        rset.updateLong(columnLabel, x);
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
        rset.updateLong(columnIndex, x);
    }

    public void updateInt(String columnLabel, int x) throws SQLException {
        rset.updateInt(columnLabel, x);
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
        rset.updateInt(columnIndex, x);
    }

    public void updateFloat(String columnLabel, float x) throws SQLException {
        rset.updateFloat(columnLabel, x);
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
        rset.updateFloat(columnIndex, x);
    }

    public void updateDouble(String columnLabel, double x) throws SQLException {
        rset.updateDouble(columnLabel, x);
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
        rset.updateDouble(columnIndex, x);
    }

    public void updateDate(String columnLabel, Date x) throws SQLException {
        rset.updateDate(columnLabel, x);
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
        rset.updateDate(columnIndex, x);
    }

    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        rset.updateClob(columnLabel, reader);
    }

    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        rset.updateClob(columnIndex, reader);
    }

    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        rset.updateClob(columnLabel, reader, length);
    }

    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        rset.updateClob(columnIndex, reader, length);
    }

    public void updateClob(String columnLabel, Clob x) throws SQLException {
        rset.updateClob(columnLabel, x);
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        rset.updateClob(columnIndex, x);
    }

    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        rset.updateCharacterStream(columnLabel, reader);
    }

    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        rset.updateCharacterStream(columnIndex, x);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        rset.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        rset.updateCharacterStream(columnIndex, x, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        rset.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        rset.updateCharacterStream(columnIndex, x, length);
    }

    public void updateBytes(String columnLabel, byte[] x) throws SQLException {
        rset.updateBytes(columnLabel, x);
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        rset.updateBytes(columnIndex, x);
    }

    public void updateByte(String columnLabel, byte x) throws SQLException {
        rset.updateByte(columnLabel, x);
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
        rset.updateByte(columnIndex, x);
    }

    public void updateBoolean(String columnLabel, boolean x) throws SQLException {
        rset.updateBoolean(columnLabel, x);
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        rset.updateBoolean(columnIndex, x);
    }

    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        rset.updateBlob(columnLabel, inputStream);
    }

    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        rset.updateBlob(columnIndex, inputStream);
    }

    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        rset.updateBlob(columnLabel, inputStream, length);
    }

    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        rset.updateBlob(columnIndex, inputStream, length);
    }

    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        rset.updateBlob(columnLabel, x);
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        rset.updateBlob(columnIndex, x);
    }

    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        rset.updateBinaryStream(columnLabel, x);
    }

    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        rset.updateBinaryStream(columnIndex, x);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        rset.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        rset.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        rset.updateBinaryStream(columnLabel, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        rset.updateBinaryStream(columnIndex, x, length);
    }

    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        rset.updateBigDecimal(columnLabel, x);
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        rset.updateBigDecimal(columnIndex, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        rset.updateAsciiStream(columnLabel, x);
    }

    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        rset.updateAsciiStream(columnIndex, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        rset.updateAsciiStream(columnLabel, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        rset.updateAsciiStream(columnIndex, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        rset.updateAsciiStream(columnLabel, x, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        rset.updateAsciiStream(columnIndex, x, length);
    }

    public void updateArray(String columnLabel, Array x) throws SQLException {
        rset.updateArray(columnLabel, x);
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        rset.updateArray(columnIndex, x);
    }

    public void setFetchSize(int rows) throws SQLException {
        rset.setFetchSize(rows);
    }

    public void setFetchDirection(int direction) throws SQLException {
        rset.setFetchDirection(direction);
    }

    public boolean rowUpdated() throws SQLException {
        return rset.rowUpdated();
    }

    public boolean rowInserted() throws SQLException {
        return rset.rowInserted();
    }

    public boolean rowDeleted() throws SQLException {
        return rset.rowDeleted();
    }

    public void refreshRow() throws SQLException {
        rset.refreshRow();
    }

    public void moveToInsertRow() throws SQLException {
        rset.moveToInsertRow();
    }

    public void moveToCurrentRow() throws SQLException {
        rset.moveToCurrentRow();
    }

    public boolean last() throws SQLException {
        return rset.last();
    }

    public boolean isLast() throws SQLException {
        return rset.isLast();
    }

    public boolean isFirst() throws SQLException {
        return rset.isFirst();
    }

    public boolean isBeforeFirst() throws SQLException {
        return rset.isBeforeFirst();
    }

    public boolean isAfterLast() throws SQLException {
        return rset.isAfterLast();
    }

    public void insertRow() throws SQLException {
        rset.insertRow();
    }

    public URL getURL(String columnLabel) throws SQLException {
        return rset.getURL(columnLabel);
    }

    public URL getURL(int columnIndex) throws SQLException {
        return rset.getURL(columnIndex);
    }

    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        return rset.getTimestamp(columnLabel, cal);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return rset.getTimestamp(columnIndex, cal);
    }

    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        return rset.getTimestamp(columnLabel);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return rset.getTimestamp(columnIndex);
    }

    public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        return rset.getTime(columnLabel, cal);
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return rset.getTime(columnIndex, cal);
    }

    public Time getTime(String columnLabel) throws SQLException {
        return rset.getTime(columnLabel);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return rset.getTime(columnIndex);
    }

    public String getString(String columnLabel) throws SQLException {
        return rset.getString(columnLabel);
    }

    public String getString(int columnIndex) throws SQLException {
        return rset.getString(columnIndex);
    }

    public short getShort(String columnLabel) throws SQLException {
        return rset.getShort(columnLabel);
    }

    public short getShort(int columnIndex) throws SQLException {
        return rset.getShort(columnIndex);
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return rset.getSQLXML(columnLabel);
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return rset.getSQLXML(columnIndex);
    }

    public RowId getRowId(String columnLabel) throws SQLException {
        return rset.getRowId(columnLabel);
    }

    public RowId getRowId(int columnIndex) throws SQLException {
        return rset.getRowId(columnIndex);
    }

    public Ref getRef(String columnLabel) throws SQLException {
        return rset.getRef(columnLabel);
    }

    public Ref getRef(int columnIndex) throws SQLException {
        return rset.getRef(columnIndex);
    }

    public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        return rset.getObject(columnLabel, map);
    }

    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        return rset.getObject(columnIndex, map);
    }

    public Object getObject(String columnLabel) throws SQLException {
        return rset.getObject(columnLabel);
    }

    public Object getObject(int columnIndex) throws SQLException {
        return rset.getObject(columnIndex);
    }

    public String getNString(String columnLabel) throws SQLException {
        return rset.getNString(columnLabel);
    }

    public String getNString(int columnIndex) throws SQLException {
        return rset.getNString(columnIndex);
    }

    public NClob getNClob(String columnLabel) throws SQLException {
        return rset.getNClob(columnLabel);
    }

    public NClob getNClob(int columnIndex) throws SQLException {
        return rset.getNClob(columnIndex);
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return rset.getNCharacterStream(columnLabel);
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return rset.getNCharacterStream(columnIndex);
    }

    public long getLong(String columnLabel) throws SQLException {
        return rset.getLong(columnLabel);
    }

    public long getLong(int columnIndex) throws SQLException {
        return rset.getLong(columnIndex);
    }

    public int getInt(String columnLabel) throws SQLException {
        return rset.getInt(columnLabel);
    }

    public int getInt(int columnIndex) throws SQLException {
        return rset.getInt(columnIndex);
    }

    public float getFloat(String columnLabel) throws SQLException {
        return rset.getFloat(columnLabel);
    }

    public float getFloat(int columnIndex) throws SQLException {
        return rset.getFloat(columnIndex);
    }

    public double getDouble(String columnLabel) throws SQLException {
        return rset.getDouble(columnLabel);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return rset.getDouble(columnIndex);
    }

    public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        return rset.getDate(columnLabel, cal);
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return rset.getDate(columnIndex, cal);
    }

    public Date getDate(String columnLabel) throws SQLException {
        return rset.getDate(columnLabel);
    }

    public Date getDate(int columnIndex) throws SQLException {
        return rset.getDate(columnIndex);
    }

    public Clob getClob(String columnLabel) throws SQLException {
        return rset.getClob(columnLabel);
    }

    public Clob getClob(int columnIndex) throws SQLException {
        return rset.getClob(columnIndex);
    }

    public Reader getCharacterStream(String columnLabel) throws SQLException {
        return rset.getCharacterStream(columnLabel);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return rset.getCharacterStream(columnIndex);
    }

    public byte[] getBytes(String columnLabel) throws SQLException {
        return rset.getBytes(columnLabel);
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return rset.getBytes(columnIndex);
    }

    public byte getByte(String columnLabel) throws SQLException {
        return rset.getByte(columnLabel);
    }

    public byte getByte(int columnIndex) throws SQLException {
        return rset.getByte(columnIndex);
    }

    public boolean getBoolean(String columnLabel) throws SQLException {
        return rset.getBoolean(columnLabel);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return rset.getBoolean(columnIndex);
    }

    public Blob getBlob(String columnLabel) throws SQLException {
        return rset.getBlob(columnLabel);
    }

    public Blob getBlob(int columnIndex) throws SQLException {
        return rset.getBlob(columnIndex);
    }

    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        return rset.getBinaryStream(columnLabel);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return rset.getBinaryStream(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        return rset.getBigDecimal(columnLabel);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return rset.getBigDecimal(columnIndex);
    }

    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        return rset.getAsciiStream(columnLabel);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return rset.getAsciiStream(columnIndex);
    }

    public Array getArray(String columnLabel) throws SQLException {
        return rset.getArray(columnLabel);
    }

    public Array getArray(int columnIndex) throws SQLException {
        return rset.getArray(columnIndex);
    }

    public void deleteRow() throws SQLException {
        rset.deleteRow();
    }

    public void cancelRowUpdates() throws SQLException {
        rset.cancelRowUpdates();
    }

}
