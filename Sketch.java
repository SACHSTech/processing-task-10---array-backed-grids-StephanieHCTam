import processing.core.PApplet;

/**
 * Draw 10 by 10 grid using 2D arrays, mouse pressed determines color change
 * @author: Stephanie Tam
 */

public class Sketch extends PApplet {

  // global variables
  int cell_Width = 20;
  int cell_Height = 20;
  int margin = 5;
  int row_Count = 10;
  int column_Count = 10;
  int screen_Width = (row_Count * cell_Width) + ((row_Count + 1) * margin);
  int screen_Height = (column_Count* cell_Height) + ((column_Count + 1) * margin);
  int row;
  int column;
  int totalCell = 0;
  
  // 2-D array of integers
  int[][] intGrid;
	
  public void settings() {

    // screen size 
    size(screen_Width, screen_Height);
  }

  public void setup() {
    background(0);

    intGrid = new int[row_Count][column_Count];
    for(int x = 0; x < row_Count; x++){
      for(int y = 0; y < column_Count; y++){
        intGrid[x][y] = 0;
      }
    }
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    //Draws Grid

    //testing: intGrid[1][5] = 1;
    
    for(int column = 0; column < column_Count; column++){
      for(int row = 0; row < row_Count; row++){
        if (intGrid[row][column] == 1){
          fill(0, 255, 0);
          rect(margin * (column+1) + (cell_Width * column), margin + (margin + cell_Height) * row, cell_Width, cell_Height);  
        }
        else{
          fill(255);
          rect(margin + (column * (cell_Width + margin)), margin + (row * (cell_Height + margin)), cell_Width, cell_Height);
        }
      }
    }
  }

  /**
   * Change the values of intGrid for draw program, outputs 
   */

  public void mousePressed(){

    for(int column = 0; column < column_Count; column ++ ){
      for(int row = 0; row < row_Count; row ++){
        if(mouseX/(cell_Width + margin) == column && mouseY/(cell_Height + margin) ==  row){
          
          // cell pressed
          if (intGrid[row][column] == 1) {
            intGrid[row][column] = 0;
            totalCell--;
          }
          else if (intGrid[row][column] == 0) {
            intGrid[row][column] = 1;
            totalCell++;
          }

          // above cell pressed
          if(row > 0 && intGrid[row -1][column] ==  1){
            intGrid[row-1][column] = 0;
            totalCell--;
          }
          else if(row > 0 && intGrid[row -1][column] == 0 ){
            intGrid[row - 1][column] = 1;
            totalCell++;
          }

          // below cell pressed
          if(row < 9 && intGrid[row + 1][column] == 1){
            intGrid[row + 1][column] = 0;
            totalCell--;
          }
          else if (row < 9 && intGrid[row + 1][column]== 0 ){
            intGrid[row + 1][column] = 1;
            totalCell++;
          }

          // right of cell pressed
          if(column < 9 && intGrid[row][column + 1] == 0 ){
            intGrid[row][column + 1] = 1;
            totalCell++;
          }
          else if(column < 9 && intGrid[row][column + 1] == 1){
            intGrid[row][column + 1] = 0;
            totalCell--;
          }

          // left of cell pressed
          if(column > 0 && intGrid[row][column -1] == 1 ){
            intGrid[row][column - 1] = 0;
            totalCell--;
          }
          else if(column > 0 && intGrid[row][column - 1] == 0 ){
            intGrid[row][column - 1] = 1;
            totalCell++;
          }

          System.out.println("Total of " + totalCell + " cells are selected");
        }
      }
    }
  }






}
