
public final class DataTable {
  
      private DataRowCollection rows; //用于保存DataRow的集合对象
      private DataColumnCollection columns; //用于保存DataColumn的对象
      private String tableName; //表名
      private boolean readOnly = false;
      private int nextRowIndex = 0;
      private DataExpression dataExpression;
      private Object tag;
   
      public DataTable() {
          this.columns = new DataColumnCollection();
          this.rows = new DataRowCollection();
          this.rows.setColumns(columns);
          dataExpression = new DataExpression(this);
      }
   
      public DataTable(String dataTableName) {
          this();
          this.tableName = dataTableName;
      }
   
      public int getTotalCount() {
          return rows.size();
      }
   
      public boolean isReadOnly() {
          return this.readOnly;
     }
  
      public void setReadOnly(boolean readOnly) {
          this.readOnly = readOnly;
     }
  
      /**  
       * 功能描述：  返回表名
       * @param    
       */
      public String getTableName() {
          return this.tableName;
      }
   
      /**  
       * 功能描述：  设置表名
       * @param    
       */
      public void setTableName(String tableName) {
          this.tableName = tableName;
      }
   
      /**  
       * 功能描述：  返回该表引用的封装类
       * @param
       * @return: DataRowCollection    
       */
      public DataRowCollection getRows() {
          return this.rows;
     }
  
      public DataColumnCollection getColumns() {
          return this.columns;
      }
   
      /**  
       * 功能描述：  获取指定行指定列的数据
       * @param
      * @return: Object    
       */
   
      public Object getValue(int row,
              String colName) {
          return this.rows.get(row).getValue(colName);
      }
   
      public Object getValue(int row,
              int col) {
          return this.rows.get(row).getValue(col);
      }
   
      /**  
       * 功能描述：  为该表数据新建一行
       * @param
       * @return: DataRow     
       */
      public DataRow newRow() throws Exception {
          DataRow tempRow = new DataRow(this);
          nextRowIndex = nextRowIndex < this.rows.size() ? this.rows.size()
                  : nextRowIndex;
          tempRow.setColumns(this.columns);
          tempRow.setRowIndex(nextRowIndex++);
          return tempRow;
      }
   
      public void setValue(int row,
              int col,
              Object value) {
          this.rows.get(row).setValue(col, value);
      }
   
      public void setValue(int row,
              String colName,
              Object value) {
          this.rows.get(row).setValue(colName, value);
      }
   
      /**  
       * @param tag
       */
      public void setTag(Object tag) {
          this.tag = tag;
      }
   
      /**  
       * @return  the tag   
      */
      public Object getTag() {
         return tag;
      }
   
      public DataColumn addColumn(String columnName,
             int dataType) throws Exception {
          return this.columns.addColumn(columnName, dataType);
     }
   
      public boolean addRow(DataRow row) throws Exception {
          if (row.getRowIndex() > this.rows.size())
              row.setRowIndex(this.rows.size());
          return this.rows.add(row);
      }
   
      //以下为数据表扩展方法实现集合
      /**  
       * 功能描述：  返回符合过滤条件的数据行集合，并返回
       * @param
       * @return: DataTable    
       */
      public List<DataRow> select(String filterString) {
          List<DataRow> rows = new ArrayList<DataRow>();
          if (StringUtil.isNotEmpty(filterString)) {
              for (Object row : this.rows) {
                 DataRow currentRow = (DataRow) row;
                  if ((Boolean) dataExpression.compute(filterString,
                          currentRow.getItemMap())) {
                      rows.add(currentRow);
                  }
             }
              return rows;
          } else {
              return this.rows;
          }
      }
   
      /**  
       * 功能描述：  对当前表进行查询 过滤，并返回指定列集合拼装的DataTable对象
       * @param
       * @return: DataTable    
      */
      public DataTable select(String filterString,
              String[] columns,
             boolean distinct) throws Exception {
          DataTable result = new DataTable();
          List<DataRow> rows = select(filterString);
         //构造表结构
          for (String c : columns) {
              DataColumn dc = this.columns.get(c);
             DataColumn newDc = new DataColumn(dc.getColumnName(),
                     dc.getDataType());
              newDc.setCaptionName(dc.getCaptionName());
              result.columns.add(newDc);
          }
         //填充数据
          for (DataRow r : rows) {
             DataRow newRow = result.newRow();
              newRow.copyFrom(r);
              result.addRow(newRow);
          }
         return result;
      }
  
     public DataTable select(String tableName,
             String selectField,
             String filterString,
              String groupField) {
         DataTable result = new DataTable();
         //
         return result;
      }
   
      /**  
       * 功能描述：  根据指定表达式对符合过滤条件的数据进行计算
       * @param
       * @return: Object
       * @author: James Cheung
       * @version: 2.0 
       */
      public Object compute(String expression,
             String filter) {
         return dataExpression.compute(expression, select(filter));
     }
   
      public Object max(String columns,
              String filter) {
         return null;
     }
   
     public Object min(String columns,
              String filter) {
          return null;
      }
   
      public Object avg(String columns,
              String filter) {
         return null;
      }
   
      public Object max(String columns,
             String filter,
             String groupBy) {
         return null;
      }
   
      public Object min(String columns,
              String filter,
             String groupBy) {
         return null;
      }
   
      public Object avg(String columns,
             String filter,
              String groupBy) {
         return null;
      }
   
      private List<DataColumn> getColumns(String colString) {
          List<DataColumn> columns = new ArrayList<DataColumn>();
   
          return columns;
     }
}
