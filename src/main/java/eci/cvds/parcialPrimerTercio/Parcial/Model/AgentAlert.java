package eci.cvds.parcialPrimerTercio.Parcial.Model;


import org.springframework.stereotype.Component;

@Component
public class AgentAlert extends Subscriber{
    public void notifyChange(String product,Integer newQuant){
        if(newQuant<=5)System.out.println("ALERT!!! The stock of the Product: " + product+ " is very low, only " + newQuant + " units left.");
        setNotified(true);
    }
}