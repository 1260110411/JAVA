 public class DataRow {
      //������м�¼��table����������
      private int rowIndex = -1; 
      private DataColumnCollection columns;
     //table��һ������
      private DataTable table; 
      //���ڴ洢���ݵ�Map�������ﱣ��Ķ��󲻰���˳����Ϣ�����ݻ�ȡ������ͨ������Ϣ��ʶ
     private Map<String, Object> itemMap = new LinkedHashMap<String, Object>();
  
     public DataRow() {
  
      }
   
     public DataRow(DataTable table) {
          this.table = table;
      }
   
      /**  
       * ����������  ��ȡ��ǰ�е�������
       * @param
       * @return: int    
       */
      public int getRowIndex() {
          return rowIndex;
      }
  
      /**  
       * ����������  ��ȡ��ǰ���������ݱ����
       * @param
       * @return: DataTable    
       */
      public DataTable getTable() {
          return this.table;
      }
   
      /**  
       * @param columns
       */
     public void setColumns(DataColumnCollection columns) {
          this.columns = columns;
      }
  
     /**  
       * @return  the columns   
       */
       public DataColumnCollection getColumns() {
          return columns;
     }
  
      public void setValue(int index,
              Object value) {
          setValue(this.columns.get(index), value);
      }
   
      public void setValue(String columnName,
              Object value) {
          setValue(this.columns.get(columnName), value);
     }
   
     public void setValue(DataColumn column,
              Object value) {
         if (column != null) {
              String lowerColumnName = column.getColumnName().toLowerCase();
              if (getItemMap().containsKey(lowerColumnName))
                 getItemMap().remove(lowerColumnName);
              getItemMap().put(lowerColumnName, column.convertTo(value));
         }
      }
   
      public Object getValue(int index) {
          String colName = this.columns.get(index).getColumnName().toLowerCase();
           return this.getItemMap().get(colName);
      }
   
      public Object getValue(String columnName) {
          return this.getItemMap().get(columnName.toLowerCase());
      }
  
     /**  
      * @return  the itemMap   
       */
     public Map<String, Object> getItemMap() {
         return itemMap;
      }
   
      /**  
       * @param rowIndex
       */
      public void setRowIndex(int rowIndex) {
          this.rowIndex = rowIndex;
     }
   
      public void copyFrom(DataRow row) {
          this.itemMap.clear();//������͵�ǰ��¼
          for (Object c : this.columns) {
             this.itemMap.put(c.toString().toLowerCase(), row.getValue(c.toString()));
         }
      }
  }
