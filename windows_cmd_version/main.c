#include <stdio.h>

int main()
{
    char degmode[0];
    int coordLat;
    int coordLon;
    int lati;
    int lon;
    char ask[0];
    // ///////////
    do
    {
        // START
        // check if half-degree or not
    printf("Half-degree waypoint? yes (y) or no (n): ");
    scanf_s("%s", &degmode);

        if(degmode[0]=='y') { // //////  HALF DEGREE MODE  //////
            printf("Enter the latitude value before '30' e.g. 89 if 8930N (use numpad): ");
            scanf_s("%d", &coordLat);

            int num=coordLat;
            int digitB = num % 10;  //split last digit from number
            num /= 10;    //divide num by 10.
            int digitA = num % 10;  //split last digit from number

            printf("Specify North (8) or South (2): ");
            scanf_s("%d", &lati);

            if(lati == 8){ // NORTH
                printf("Enter the longitude value: ");
                scanf_s("%d", &coordLon);
                printf("Specify West (4) or East (6): ");
                scanf_s("%d", &lon);
                if(lon==4){
                    printf("||| Sel: %d30 N %d W |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dN%d00 *** WEST\n", digitA, digitB); // split digit
                    else if(coordLon==0) printf("\n*** N%d00 *** WEST\n", coordLat);
                    else if(coordLon<100) printf("\n*** N%d%d *** WEST\n", coordLat, coordLon);
                    else printf("\n*** %dN%d%d *** WEST\n", digitA, digitB, coordLon-100); // split digit
                }
                else {
                    printf("||| Sel: %d30 N %d E |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dE%d00 *** EAST\n", digitA, digitB); // split digit
                    else if(coordLon==0) printf("\n*** E%d00 *** EAST\n", coordLat);
                    else if(coordLon<100) printf("\n*** E%d%d *** EAST\n", coordLat, coordLon);
                    else printf("\n*** %dE%d%d *** EAST\n", digitA, digitB, coordLon-100); // split digit and 100 offset
                }}
            else { // SOUTH
                printf("Enter the longitude value: ");
                scanf_s("%d", &coordLon);
                printf("Specify West (4) or East (6): ");
                scanf_s("%d", &lon);
                if(lon==4){
                    printf("||| Sel: %d30 S %d W |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dW%d00 *** WEST\n", digitA, digitB); // split digit
                    else if(coordLon==0) printf("\n*** W%d00 *** WEST\n", coordLat);
                    else if(coordLon<100) printf("\n*** W%d%d *** WEST\n", coordLat, coordLon);
                    else printf("\n*** %dW%d%d *** WEST\n", digitA, digitB, coordLon-100); // split digit
                }
                else {
                    printf("||| Sel: %d30 S %d E |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dS%d00 *** EAST\n", digitA, digitB); // split digit
                    else if(coordLon==0) printf("\n*** S%d00 *** EAST\n", coordLat);
                    else if(coordLon<100) printf("\n*** S%d%d *** EAST\n", coordLat, coordLon);
                    else printf("\n*** %dS%d%d *** EAST\n", digitA, digitB, coordLon-100); // split digit and 100 offset
                }}
        } // ////// END HALF DEGREE MODE  //////

        else { // //////  FULL DEGREE MODE  //////
            printf("Enter the latitude value (use numpad): ");
            scanf_s("%d", &coordLat);

            printf("Specify North (8) or South (2): ");
            scanf_s("%d", &lati);

            if(lati == 8){ // NORTH
                printf("Enter the longitude value: ");
                scanf_s("%d", &coordLon);
                printf("Specify West (4) or East (6): ");
                scanf_s("%d", &lon);
                if(lon==4){
                    printf("||| Sel: %d N %d W |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dN00 *** WEST\n", coordLat);
                    else if(coordLon==0) printf("\n*** %d00N *** WEST\n", coordLat);
                    else if(coordLon<100) printf("\n*** %d%dN *** WEST\n", coordLat, coordLon);
                    else printf("\n*** %dN%d *** WEST\n", coordLat, coordLon-100);
                }
                else {
                    printf("||| Sel: %d N %d E |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dE00 *** EAST\n", coordLat);
                    else if(coordLon==0) printf("\n*** %d00E *** EAST\n", coordLat);
                    else if(coordLon<100) printf("\n*** %d%dE *** EAST\n", coordLat, coordLon);
                    else printf("\n*** %dE%d *** EAST\n", coordLat, coordLon-100);
                }}
            else { // SOUTH
                printf("Enter the longitude value: ");
                scanf_s("%d", &coordLon);
                printf("Specify West (4) or East (6): ");
                scanf_s("%d", &lon);
                if(lon==4){
                    printf("||| Sel: %d S %d W |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dW00 *** WEST\n", coordLat);
                    else if(coordLon==0) printf("\n*** %d00W *** WEST\n", coordLat);
                    else if(coordLon<100) printf("\n*** %d%dW *** WEST\n", coordLat, coordLon);
                    else printf("\n*** %dW%d *** WEST\n", coordLat, coordLon-100);
                }
                else {
                    printf("||| Sel: %d S %d E |||\n", coordLat, coordLon); // next step: is W or E <100?
                    if(coordLon==100) printf("\n*** %dS00 *** EAST\n", coordLat);
                    else if(coordLon==0) printf("\n*** %d00S *** EAST\n", coordLat);
                    else if(coordLon<100) printf("\n*** %d%dS *** EAST\n", coordLat, coordLon);
                    else printf("\n*** %dS%d *** EAST\n", coordLat, coordLon-100);
                }}
            // ///// END FULL DEGREE MODE /////
        }
        printf("\n Continue? yes (y) or no (n): ");
        scanf_s("%s", &ask);

    }while(ask[0]=='y');
    return 0;
}
