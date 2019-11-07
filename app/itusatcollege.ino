#include <InternetButton.h>
 
InternetButton button = InternetButton();


void setup() {
  button.begin();

  Particle.function("hitMe", itusAtcollege);
 

}

int itusAtcollege(String cmd){
  
      if(cmd == "faceA"){
       button.ledOn(0, 255, 255, 255);
       button.ledOn(1, 255, 255, 255);
       button.ledOn(2, 255, 255, 255);
       button.ledOn(3, 255, 255, 255);
       button.ledOn(9, 255, 255, 255);
       button.ledOn(10, 255, 255, 255);
       button.ledOn(11, 255, 255, 255);
       button.ledOn(5, 255, 255, 255);
       button.ledOn(7, 255, 255, 255);
        
    }
    
    else if (cmd == "faceB"){
       button.ledOn(0, 255, 255, 255);
       button.ledOn(1, 255, 255, 255);
       button.ledOn(2, 255, 255, 255);
    //   button.ledOn(3, 255, 255, 255);
       button.ledOn(10, 255, 255, 255);
       button.ledOn(11, 255, 255, 255);
       button.ledOn(5, 255, 255, 255);
       button.ledOn(7, 255, 255, 255);
    //   button.ledOn(9, 255, 255, 255);
       
    }
    
    else if (cmd == "faceC"){
       button.ledOn(0, 255, 255, 255);
       button.ledOn(1, 255, 255, 255);
    //   button.ledOn(2, 255, 255, 255);
    //   button.ledOn(10, 255, 255, 255);
       button.ledOn(11, 255, 255, 255);
       button.ledOn(5, 255, 255, 255);
       button.ledOn(7, 255, 255, 255);
  
    }
    
    else if(cmd == "faceD"){
       button.ledOn(0, 255, 255, 255);
    //   button.ledOn(1, 255, 255, 255);
       button.ledOn(2, 255, 255, 255);
       button.ledOn(10, 255, 255, 255);
    //   button.ledOn(11, 255, 255, 255);
       button.ledOn(5, 255, 255, 255);
       button.ledOn(7, 255, 255, 255);
   

    }
    
    else if(cmd == "faceE"){
       button.allLedsOn(255,0,0);
       delay(4000);
       button.allLedsOff();
    }
    
    else{
        return - 1;
    }
    
    return 1;
    
}

int DELAY = 300;

void loop() {
}
      
   
 
