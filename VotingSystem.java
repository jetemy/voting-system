
package votingsystem;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VotingSystem {

    public static void main(String[] args) throws SQLException {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                try {
                    new votingsystem.login.Login().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VotingSystem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
