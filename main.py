    operator = input("Enter An opreator (+ - * /):")
    x = float(input("Type The First number which calculates Vari x equals?"))
    y = float(input("Type The 2nd number which calculates Vari y equals?"))


    if operator == "+":
        print(x + y)
    elif operator == "-":
        print(x - y)

    elif operator == "*":
        print(x * y)

    elif operator == "/":
        sww = input("What Number would u start with?(num1 y):")
        if sww == "num1":
         print (x / y)


        elif sww == "y" :
            print(y / x)

