// Explore a simple class

println("UW Homework: Simple Kotlin")

// write a "whenFn" that takes an arg of type "Any" and returns a String

fun whenFn(word: Any): Any { 
    return when (word) { 
        "Hello" ->  "world"
        is String  -> "I don't understand"
        0 -> "zero" 
        1 -> "one"
        in 2..10 -> "low number"  
        is Int -> "a number"
        else -> "Say what?"
    }
}


// write an "add" function that takes two Ints, returns an Int, and adds the values

fun add(num1: Int, num2: Int): Int { 
    return num1 + num2
}

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values

fun sub(num1: Int, num2: Int): Int { 
    return num1 - num2
}

// write a "mathOp" function that takes two Ints and a function 
//(that takes two Ints and returns an Int), returns an Int, and applies 
//the passed-in-function to the arguments

fun mathOp(num1: Int, num2: Int, fun(num1: Int, num2: Int): Int): Int  {
   
}
// write a class "Person" with first name, last name and age
class Person(var firstName: String, val lastName: String, var age: Int) {
    val debugString = "[Person firstName:" + firstName + " lastName:"+ lastName +" age:" + age + "]"
}
// write a class "Money"
class Money() { 
    public var money: String = ""
    // get() = field 
    // set(value) { 
    //     field = if (value !=  "USD" || value !=  "EUR" || value != "CAN" value !=  "GBP") { 
    //          throw IllegalArgumentException("Not valid currency")
    //     } else { 
    //         value
    //     }
    // }
    public var amount: Int = 0
    // get() = field 
    // set(value) { 
    //     field = if (value >= 0) { 
    //         throw IllegalArgumentException("Not valid amount")
    //     } else { 
    //         value
    //     }
    // }

    class convert(currency: String): Int { 
        if currency == "USD"  
            if money == "USD" 
                return amount;
             else if money == "GBP"  
                return amount * 2;
             else if (money == "EUR")  
                return amount * (2/3); 
             else if (money == "CAN")  
                return amount / 1.25;
         else if (currency == "EUR")  
            if (money == "USD")  
                return amount * (3/2);
             else if (money == "GBP")  
                return amount * 3;
             else if (money == "EUR")  
                return amount; 
             else if (money == "CAN")  
                return amount / 1.25;
        else if (currency == "CAN") 
            if money = "USD" 
                return amount * 1.25;
         else if (currency == "GBP")  
            if (money == "USD") 
                return amount / 2;
            else if (money == "GBP")  
                return amount;
            else if (money == "EUR")  
                return amount * 3; 
            
        
    }
}

// ============ DO NOT EDIT BELOW THIS LINE =============

print("When tests: ")
val when_tests = listOf(
    "Hello" to "world",
    "Howdy" to "Say what?",
    "Bonjour" to "Say what?",
    0 to "zero",
    1 to "one",
    5 to "low number",
    9 to "low number",
    17.0 to "I don't understand"
)
for ((k,v) in when_tests) {
    print(if (whenFn(k) == v) "." else "!")
}
println("")

print("Add tests: ")
val add_tests = listOf(
    Pair(0, 0) to 0,
    Pair(1, 2) to 3,
    Pair(-2, 2) to 0,
    Pair(123, 456) to 579
)
for ( (k,v) in add_tests) {
    print(if (add(k.first, k.second) == v) "." else "!")
}
println("")

print("Sub tests: ")
val sub_tests = listOf(
    Pair(0, 0) to 0,
    Pair(2, 1) to 1,
    Pair(-2, 2) to -4,
    Pair(456, 123) to 333
)
for ( (k,v) in sub_tests) {
    print(if (sub(k.first, k.second) == v) "." else "!")
}
println("")

print("Op tests: ")
print(if (mathOp(2, 2, { l,r -> l+r} ) == 4) "." else "!")
print(if (mathOp(2, 2, ::add ) == 4) "." else "!")
print(if (mathOp(2, 2, ::sub ) == 0) "." else "!")
print(if (mathOp(2, 2, { l,r -> l*r} ) == 4) "." else "!")
println("")


print("Person tests: ")
val p1 = Person("Ted", "Neward", 47)
print(if (p1.firstName == "Ted") "." else "!")
p1.age = 48
print(if (p1.debugString == "[Person firstName:Ted lastName:Neward age:48]") "." else "!")
println("")

print("Money tests: ")
val tenUSD = Money(10, "USD")
val twelveUSD = Money(12, "USD")
val fiveGBP = Money(5, "GBP")
val fifteenEUR = Money(15, "EUR")
val fifteenCAN = Money(15, "CAN")
val convert_tests = listOf(
    Pair(tenUSD, tenUSD),
    Pair(tenUSD, fiveGBP),
    Pair(tenUSD, fifteenEUR),
    Pair(twelveUSD, fifteenCAN),
    Pair(fiveGBP, tenUSD),
    Pair(fiveGBP, fifteenEUR)
)
for ( (from,to) in convert_tests) {
    print(if (from.convert(to.currency).amount == to.amount) "." else "!")
}
val moneyadd_tests = listOf(
    Pair(tenUSD, tenUSD) to Money(20, "USD"),
    Pair(tenUSD, fiveGBP) to Money(20, "USD"),
    Pair(fiveGBP, tenUSD) to Money(10, "GBP")
)
for ( (pair, result) in moneyadd_tests) {
    print(if ((pair.first + pair.second).amount == result.amount &&
              (pair.first + pair.second).currency == result.currency) "." else "!")
}
println("")