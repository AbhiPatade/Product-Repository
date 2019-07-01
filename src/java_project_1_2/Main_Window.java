package java_project_1_2;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;





public class Main_Window extends javax.swing.JFrame {

    /**
     * Creates new form Main_Window
     */
    public Main_Window()  {
       initComponents();
       DB.getConnection();
        
    }

  String ImgPath=null;
    int pos=0;
    /*
   public  Connection getConnection()
    {
       Connection con=null;
        try {
          Class.forName("com.mysql.cj.jdbc.Driver");
		     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/products_db2","root","root");
                       // String url="jdbc:mysql://localhost:3306/test?useSSL=false";
                 //con=DriverManager.getConnection(url,"root","root");
            JOptionPane.showMessageDialog(null,"connected");
           //return con;
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Not connected");
              //return null;
              
        }
      
        return con;
    }
    */
    //check input fields
   public boolean checkInputs()
   {
       if(
         txt_name.getText()==null
               ||txt_price.getText()==null
               //|| txt_AddDate.getDate()==null
         ){
           return false;
          }else{
                try{
                   Float.parseFloat(txt_price.getText());
                   return true;
                   
                }
                catch(Exception ex)
                {
                    return false;
                }
                    
               }
   }


    //resize image
    public ImageIcon ResizeImage(String imagePath,byte[] pic)
    {
        ImageIcon myImage=null;
        
        if(imagePath!=null)
        {
            myImage=new ImageIcon(imagePath);
        }else{
            myImage=new ImageIcon(pic);
             }
        Image img=myImage.getImage();
        Image img2=img.getScaledInstance(lb1_image.getWidth(), lb1_image.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon image=new ImageIcon(img2);
        return image;
    }
    
    
    public ArrayList<Product> getProductList()
    {
                    ArrayList<Product> productList = new ArrayList<>();
            Connection con = DB.getConnection();
            String query="select * from products";
            
            Statement st;
            ResultSet rs;
    try {
            
            st=con.createStatement();
            rs=st.executeQuery(query);
            Product product;
            
           while(rs.next())
           {
               product =new Product(rs.getInt("id"),rs.getString("name"),Float.parseFloat(rs.getString("price")),rs.getString("add_date"),rs.getByte("image"));
               productList.add(product);
           }
        } catch (SQLException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    return productList;
    }
  
    //2.populate the JTable
    public void show_Products_in_JTable()
    {
        
        ArrayList<Product> List=getProductList();
        DefaultTableModel mode1= (DefaultTableModel)Jtable_Products.getModel();
        //clear the Jtable content
        mode1.setRowCount(0);
        Object[] row= new Object[4];
        for(int i=0;i<List.size();i++)
        {
            row[0] =List.get(i).getId();
            row[1] =List.get(i).getName();
            row[2] =List.get(i).getPrice();
            row[3] =List.get(i).getAdddate();
            
            mode1.addRow(row);
            
        }
     }
    
    public void ShowItem(int index)
    {
        txt_id.setText(Integer.toString(getProductList().get(index).getId()));
            txt_name.setText(getProductList().get(index).getName());
            txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
        try {
            Date addDate=null;
            addDate=new SimpleDateFormat("yyyy-MM-dd").parse((String)getProductList().get(index).getAdddate());
           txt_AddDate.setDate(addDate);
        } catch (ParseException ex) {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        lb1_image.setIcon(ResizeImage(null,getProductList().get(index).getImage()));
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        lb1_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Jtable_Products = new javax.swing.JTable();
        ChooseImage = new javax.swing.JButton();
        btn_Add = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_first = new javax.swing.JButton();
        btn_previous = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        txt_AddDate = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("ID:-");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Name:-");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Price:-");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Add Date:-");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Image:-");

        txt_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_id.setPreferredSize(new java.awt.Dimension(59, 40));
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        txt_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_name.setPreferredSize(new java.awt.Dimension(59, 40));
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        txt_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_price.setPreferredSize(new java.awt.Dimension(59, 40));
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        lb1_image.setBackground(new java.awt.Color(51, 255, 255));
        lb1_image.setOpaque(true);

        Jtable_Products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Add Date"
            }
        ));
        Jtable_Products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Jtable_ProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Jtable_Products);

        ChooseImage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ChooseImage.setText("Choose Image");
        ChooseImage.setActionCommand("");
        ChooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseImageActionPerformed(evt);
            }
        });

        btn_Add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_icons/add.png"))); // NOI18N
        btn_Add.setText("Add");
        btn_Add.setIconTextGap(2);
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_icons/delete1.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setIconTextGap(2);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_next.setText("Next");
        btn_next.setIconTextGap(2);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_icons/update1.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.setIconTextGap(2);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_first.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_icons/First Icons - Download 46 Free First icons here_files/Button-First-icon.png"))); // NOI18N
        btn_first.setText("First");
        btn_first.setIconTextGap(2);
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_previous.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_previous.setText("Previous");
        btn_previous.setIconTextGap(2);
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/java_icons/Last Icons - Download 67 Free Last icons here_files/Actions-go-last-view-icon.png"))); // NOI18N
        btn_last.setText("Last");
        btn_last.setIconTextGap(2);
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        txt_AddDate.setDateFormatString("yyyy-MM-dd\n"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ChooseImage, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb1_image, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txt_price, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_AddDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb1_image, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(ChooseImage)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_previous, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txt_AddDate.getAccessibleContext().setAccessibleParent(txt_AddDate);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1032, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(346, 346, 346)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
       
       if(checkInputs() && ImgPath!=null)
       {
           try {
                Connection con=DB.getConnection();
               PreparedStatement ps=con.prepareStatement("INSERT INTO products(name,price,add_date,image"
                       + "values(?,?,?,?))");
               ps.setString(1,txt_name.getText());
               ps.setString(2,txt_price.getText());
               
              // SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
              SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
               //String addDate=dateFormat.format(txt_AddDate.getDate());    //change
                String addDate=dateFormat.format(txt_AddDate.getDate());
             
               ps.setString(3,addDate);
               
               InputStream img=new FileInputStream(new File(ImgPath));
               ps.setBlob(4,img);
               
               ps.executeUpdate();
               show_Products_in_JTable();
                JOptionPane.showMessageDialog(null,"data inserted.....");
               
           } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,ex.getStackTrace());
           }
       }else
       {
           JOptionPane.showMessageDialog(null,"one or more fields are empty!!!");
       }
       System.out.println("Name==>"+txt_name.getText());
       System.out.println("Price==>"+txt_price.getText());
       System.out.println("Image==>"+ImgPath);
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(checkInputs() && txt_id!=null)
        {
        String UpdateQuery=null;
        PreparedStatement ps=null;
        Connection con = DB.getConnection();
        
        //update without image
        if(ImgPath==null)
        {
            try {
                UpdateQuery="UPDATE products SET name=?,price=?,add_date=? where id=?";
                ps= con.prepareStatement(UpdateQuery);
                
                ps.setString(1,txt_name.getText());
                ps.setString(2,txt_price.getText());
               
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
               String addDate=dateFormat.format(txt_AddDate.getDate());    //change
               ps.setString(3,addDate);
               
               ps.setInt(4,Integer.parseInt(txt_id.getText()));
               ps.executeUpdate();
               show_Products_in_JTable();
               JOptionPane.showMessageDialog(null,"products updated");
               
            } catch (SQLException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            try{
             InputStream img=new FileInputStream(new File(ImgPath));
             UpdateQuery="UPDATE products SET name=?,price=?,add_date=?,image=? where id=?";
              ps= con.prepareStatement(UpdateQuery);
                
                ps.setString(1,txt_name.getText());
                ps.setString(2,txt_price.getText());
               
                SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
               String addDate=dateFormat.format(txt_AddDate.getDate());    //change
               ps.setString(3,addDate);
               ps.setBlob(4, img);
               ps.setInt(5,Integer.parseInt(txt_id.getText()));
               
               ps.executeUpdate();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        }
        else{
            JOptionPane.showMessageDialog(null,"one or more fields are empty!!!");
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
     
        if(!txt_id.getText().equals(""))
        {
            try {
                Connection con= DB.getConnection();
                PreparedStatement ps= con.prepareStatement("DELETE FROM products where id=?");
                int id=Integer.parseInt(txt_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                show_Products_in_JTable();
                JOptionPane.showMessageDialog(null,"product deleted...");
            } catch (SQLException ex) {
                Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"product not deleted");
                
            }
            
        }
        else{
             JOptionPane.showMessageDialog(null,"product not deleted:no id to delete ");
            }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
      pos++;
      
      if(pos > getProductList().size())
      {
          pos=getProductList().size()-1;
      }
        ShowItem(pos);
    }//GEN-LAST:event_btn_nextActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        
        pos=0;
        ShowItem(pos);
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        
        pos--;
      
      if(pos < 0)
      {
          pos=0;
      }
        ShowItem(pos);
    }//GEN-LAST:event_btn_previousActionPerformed

    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
       pos=getProductList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_lastActionPerformed

    private void ChooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseImageActionPerformed
    
       JFileChooser file=new JFileChooser();
       file.setCurrentDirectory(new File(System.getProperty("user.home")));
       FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
       file.addChoosableFileFilter(filter);
       int result=file.showSaveDialog(null);
       if(result==JFileChooser.APPROVE_OPTION)
       {
           File selectedFile=file.getSelectedFile();
           String path=selectedFile.getAbsolutePath();
           lb1_image.setIcon(ResizeImage(path,null));
           ImgPath=path;
       }
       else{
           System.out.println("no file selected!!!!!!");
       }
    }//GEN-LAST:event_ChooseImageActionPerformed

    private void Jtable_ProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Jtable_ProductsMouseClicked
        
        int index=Jtable_Products.getSelectedRow();
        ShowItem(index);
        
    }//GEN-LAST:event_Jtable_ProductsMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ChooseImage;
    private javax.swing.JTable Jtable_Products;
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb1_image;
    private com.toedter.calendar.JDateChooser txt_AddDate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    // End of variables declaration//GEN-END:variables
}
