# note in Python 3 // operator is truncated division.

for row in range(0,height):
    
    if (0 <= abs(height//2-row) <= 2):

        count = abs(abs(height//2-row)-2))
        
        for column in range(0,width):
         
            if (width//2-count <= column <= width//2-count):
                print("*")
            else:
                print(" ")

    else:

        for column in range(0,width):
            print(" ")
