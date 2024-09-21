package eci.cvds.parcialPrimerTercio.Parcial.Model;

import org.springframework.stereotype.Component;

@Component
public abstract class Subscriber {
    public boolean notified = false;
    public abstract void notifyChange(String product,Integer newQuant);
    public void setNotified(Boolean bool){
        notified = bool;
    }
    public Boolean wasNotified(){
        return this.notified;
    }
}