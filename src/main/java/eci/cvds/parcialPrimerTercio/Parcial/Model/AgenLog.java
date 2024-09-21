package eci.cvds.parcialPrimerTercio.Parcial.Model;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class AgenLog extends Subscriber {
    public void notifyChange(String product,Integer newQuant){
        System.out.println("Product: "+ product + " -> "+ newQuant+ " available units");
        setNotified(true);
    }
}
