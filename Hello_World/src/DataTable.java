
public final class DataTable {
  
      private DataRowCollection rows; //���ڱ���DataRow�ļ��϶���
      private DataColumnCollection columns; //���ڱ���DataColumn�Ķ���
      private String tableName; //����
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
       * ����������  ���ر���
       * @param    
       */
      public String getTableName() {
          return this.tableName;
      }
   
      /**  
       * ����������  ���ñ���
       * @param    
       */
      public void setTableName(String tableName) {
          this.tableName = tableName;
      }
   
      /**  
       * ����������  ���ظñ����õķ�װ��
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
       * ����������  ��ȡָ����ָ���е�����
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
       * ����������  Ϊ�ñ������½�һ��
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
   
      //����Ϊ���ݱ���չ����ʵ�ּ���
      /**  
       * ����������  ���ط��Ϲ��������������м��ϣ�������
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
       * ����������  �Ե�ǰ����в�ѯ ���ˣ�������ָ���м���ƴװ��DataTable����
       * @param
       * @return: DataTable    
      */
      public DataTable select(String filterString,
              String[] columns,
             boolean distinct) throws Exception {
          DataTable result = new DataTable();
          List<DataRow> rows = select(filterString);
         //�����ṹ
          for (String c : columns) {
              DataColumn dc = this.columns.get(c);
             DataColumn newDc = new DataColumn(dc.getColumnName(),
                     dc.getDataType());
              newDc.setCaptionName(dc.getCaptionName());
              result.columns.add(newDc);
          }
         //�������
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
       * ����������  ����ָ�����ʽ�Է��Ϲ������������ݽ��м���
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
