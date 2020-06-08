
public class DataColumn {
    private boolean readOnly; // 只读
   
      private DataTable table; //dataTable的引用
   
      private String columnName; //列名
   
      private String captionName; //显示名称
   
      private int columnIndex;//列索引
   
      private int dataType;//列数据类型
   
      private String dataTypeName;//数据类型名称
   
      public DataColumn() {
          this("default1");
      }
   
      public DataColumn(int dataType) {
          this("default1", dataType);
      }
  
      public DataColumn(String columnName) {
          this(columnName, 0);
      }
   
      public DataColumn(String columnName, int dataType) {
          this.setDataType(dataType);
          this.columnName = columnName;
      }
   
      public String getColumnName() {
          return this.columnName;
      }
   
      public void setColumnName(String columnName) {
          this.columnName = columnName;
      }
   
      public String getCaptionName() {
          return captionName;
      }
   
      public void setCaptionName(String captionName) {
          this.captionName = captionName;
      }
   
      public boolean isReadOnly() {
          return this.readOnly;
      }
   
      public void setReadOnly(boolean readOnly) {
          this.readOnly = readOnly;
      }
   
      public DataTable getTable() {
          return this.table;
     }
   
      public void setTable(DataTable table) {
          this.table = table;
      }
   
      /**  
       * @param dataType
   */
   public void setDataType(int dataType) {
         this.dataType = dataType;
      }
   
      /**  
       * @return  the dataType   
      */
      public int getDataType() {
          return dataType;
      }
   
      /**  
       * @param columnIndex
       */
      public void setColumnIndex(int columnIndex) {
          this.columnIndex = columnIndex;
      }
   
      /**  
       * @return  the columnIndex   
      */
      public int getColumnIndex() {
          return columnIndex;
      }
   
      public String getDataTypeName() {
          return DataTypes.getDataTypeName(dataType);
      }
   
      /**  
       * 功能描述：  将输入数据转为当前列的数据类型返回
      * @param
       */
      public Object convertTo(Object value) {
          return value;
      }
      
      @Override
      public String toString(){
          return this.columnName;
      }
}
