
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;



public class ListarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ListarUsuarios
     */
    public ListarUsuarios() {
        initComponents();
        try{
        // 1 -Conectar com o banco de dados
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection conectado = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root","admin");
       // 2 - Buscar todos os usuarios cadastrados na tabela do banco de dados
        PreparedStatement st = conectado.prepareStatement("SELECT * FROM usuarios");
        ResultSet usuarios = st.executeQuery(); //Executa o Select
        DefaultTableModel tblModelo = (DefaultTableModel) tblUsuarios.getModel ();
        while (usuarios.next()){
            String linha [] = {
            usuarios.getString("usuario"),
            usuarios.getString ("senha"),
            usuarios.getString("cargo")    
            };
            tblModelo.addRow(linha);
            
            
        }
        
     }  catch (ClassNotFoundException  ex) {
        JOptionPane.showMessageDialog(null, "Driver não colocado na library");
     }  catch (SQLException ex){
        JOptionPane.showMessageDialog (null, "Erro no banco de dados" + ex.getMessage());
      
       }
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Usuários");
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(null);

        tblUsuarios.setBackground(new java.awt.Color(242, 242, 242));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Usuário", "Senha", "Cargo"
            }
        ));
        jScrollPane1.setViewportView(tblUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 40, 520, 280);

        setSize(new java.awt.Dimension(638, 373));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
