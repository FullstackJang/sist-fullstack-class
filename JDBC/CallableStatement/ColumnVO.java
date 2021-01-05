package day0104;

public class ColumnVO {
	private String columnName;
	private String dataType;
	private int precision;
	private int nullable;
	
	public ColumnVO() {
		
	}

	public ColumnVO(String columnName, String dataType, int precision, int nullable) {
		this.columnName = columnName;
		this.dataType = dataType;
		this.precision = precision;
		this.nullable = nullable;
	}//ColumnVO

	public String getColumnName() {
		return columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public int getPrecision() {
		return precision;
	}

	public int getNullable() {
		return nullable;
	}

	@Override
	public String toString() {
		return "ColumnVO [columnName=" + columnName + ", dataType=" + dataType + ", precision=" + precision
				+ ", nullable=" + nullable + "]";
	}
	
}//class
