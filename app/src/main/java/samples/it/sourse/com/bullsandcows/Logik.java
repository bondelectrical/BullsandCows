package samples.it.sourse.com.bullsandcows;

import java.util.ArrayList;

/**
 * Created by Home on 14.06.2015.
 */
public class Logik {

    public static Integer[] rezultRandom(ArrayList<Integer> numberScreen ) {
        int cows = 0;
        int bull = 0;
        Integer[] rezultRandom = new Integer[2];
        ArrayList<Integer> randomTemp = new ArrayList<>(3);

        randomTemp.add((int) (Math.random() * 9 + 1));
        for (int i = 0; i < 3; i++){
            Integer temp = rand();
            while (randomTemp.contains(temp) == true){
                temp = rand();
            }
            randomTemp.add(temp);
        }
        Integer random = (randomTemp.get(0)*1000 + randomTemp.get(1)*100 + randomTemp.get(2)*10 + randomTemp.get(3));
//        checking cows
        for(int tempNumberScreen : numberScreen){
            if (randomTemp.contains(tempNumberScreen)){
                cows++;
            }
        }

//        checking bull
        for (int i = 0; i < 3; i++) {
            if (numberScreen.get(i) == randomTemp.get(i)) {
                bull++;
            }
        }

        rezultRandom[0] = cows;
        rezultRandom[1] = bull;


        return rezultRandom;
    }

    private static Integer rand() {
        return (int) (Math.random()*10);
    }
}
