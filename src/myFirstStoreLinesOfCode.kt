
fun main() {
    val myListOneOfProducts = mutableListOf("chicken", "rice", "juice", "mango")
    val myListOfPrices = mutableListOf(3.30, 4.00, 5.20, 2.40)

    try {
        loop@ do {

            val options: String? = """
        Hi! Welcome to MyStore what would you like to do today?
        
        1. Add a product and price
        2. remove a product and price
        3. look a product price by it's name
        4. look a product name by it's price
        5. Exit
        
    """.trimIndent()
            print("\n")
            print(options)
            print("\n")
            print("Select one of our options: ")
            val myInput = readLine()!!.toInt()

            print("\n")
            when (myInput) {
                1 -> {
                    //1. Add a product and price
                    print("How would you like to name the new product: ")
                    val newProduct = readLine()
                    if (newProduct != null) {
                        myListOneOfProducts.add(newProduct)
                        if (newProduct.isEmpty()) {
                            print("You need to ingress a value. Try again")
                            break@loop
                        }
                    }

                    print("\n")
                    print("what would you like the price of this product to be: $ ")


                    val newPrice = readLine()?.toDouble()
                    if (newPrice != null) {
                        if (newPrice >= 0) {
                            myListOfPrices.add(newPrice)
                        } else {
                            print("You can't assign a negative price, try again")
                            break@loop
                        }
                    }

                    print("\n")
                    print("These are the products and prices up to date: ")
                    print("\n")
                    for (number in 0 until myListOneOfProducts.size) {
                        println("${myListOneOfProducts[number]}: $${myListOfPrices[number]} ")
                    }

                    print("\n")
                    print("Number of products: ${myListOneOfProducts.size}, Number of prices ${myListOfPrices.size}")
                    print("\n")

                }

                2 -> {
                    //2. remove a product and price
                    print("Which product would you like to remove today?")
                    print("\n")
                    print("These are the products that we have available now: ")
                    print("\n")
                    var x = 1
                    for (product in myListOneOfProducts) {
                        println("$x. $product")
                        x++
                    }
                    print("\n")
                    print("Write the name of the product that you like to remove: ")

                    val removeProduct = readLine()?.toLowerCase()

                    if (myListOneOfProducts.contains(removeProduct)) {
                        val z = myListOneOfProducts.indexOf(removeProduct)
                        print("This is $z")
                        myListOfPrices.removeAt(z)

                        myListOneOfProducts.remove(removeProduct)
                    } else {
                        print("You had a typo or you are writing a product that is not on the list. Try again")
                        break@loop
                    }

                    print("\n")
                    print("This is the updated list of products")
                    print("\n")

                    var y = 1
                    for (product in myListOneOfProducts) {
                        println("$y. $product")
                        y++
                    }

                    print("\n")
                    print("This is the updated list of prices")
                    print("\n")

                    val r = 1
                    for (price in myListOfPrices) {
                        println("$r. $price")
                    }

                    print("\n")
                    print("Thanks for joining us! ")
                    print("\n")

                }
                3 -> {
                    // 3. look a product price by it's name
                    print("Please write the name of the product that you are looking for and we will let you know the price of it:")

                    print("\n")
                    print("These are the products that we currently have: ")
                    print("\n")
                    var p = 1
                    for (product in myListOneOfProducts) {
                        println("$p. $product")
                        p++
                    }

                    val productName = readLine()?.toLowerCase()
                    if (myListOneOfProducts.contains(productName)) {
                        val indexProduct = myListOneOfProducts.indexOf(productName)
                        print("The price of $productName is ${myListOfPrices[indexProduct]}")
                        print("\n")
                    } else {
                        print("You are writing a product that doesn't exist in our records. Try again")
                        print("\n")
                        break@loop
                    }


                }
                4 -> {
                    //4. look a product name by it's price
                    print("\n")
                    print("If you are looking for a product, these are our prices. Write the price and find the product for that price: ")
                    print("\n")
                    var l = 1
                    for (price in myListOfPrices) {
                        println("$l. $price")
                        l++
                    }


                    val myPriceForAProduct = readLine()?.toLowerCase()?.toDouble()
                    if (myListOfPrices.contains(myPriceForAProduct)) {
                        val indexPrice = myListOfPrices.indexOf(myPriceForAProduct)
                        print("You wrote the price $myPriceForAProduct. This is equal to ${myListOneOfProducts[indexPrice]}")
                        print("\n")
                    } else {
                        print("None of our products have that price. Try again")
                        print("\n")
                        break@loop
                    }

                }
                5 -> {
                    print("\n")
                    print("Thanks for coming to MYStore! Hope you have a great day!")
                    print("\n")
                    break@loop
                }
            }
        } while (myInput in 1 until 5)
    } catch (exception: NumberFormatException) {
        print("You have to select a a number from 1 to 5")
    }
}
