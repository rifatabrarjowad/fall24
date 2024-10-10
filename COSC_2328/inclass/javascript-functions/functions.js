console.log('In Class Assignment 6a');
console.log("------ Part 1: Creating a Function ------");

function totalPay(hours, hourlyRate, base = 4) {
    return hours * hourlyRate + base;
}

const result1 = totalPay(4, 2.5, 3);
console.log("Total Pay: " + result1);
const result2 = totalPay(4, 2.5);
console.log("Total Pay (default base): " + result2);

// Part 2: Nested Function
console.log("------ Part 2: Nested Function ------");

function totalPay2(hours, hourlyRate, base) {
    function hourlyPay() {
        return hours * hourlyRate;
    }
    return base + hourlyPay();
}

// Execute the nested function
const result3 = totalPay2(6, 1.5, 2);
console.log("Total Pay (inner func): " + result3);

// Part 3: Functions as Objects
console.log("----- Part 3: Functions as Objects -----");

function totalPay3(hours, hourlyRate, base, hourlyPayFunction) {
    return base + hourlyPayFunction();
}

// Define the outer hourlyPay function
function hourlyPayOuter(hours, hourlyRate) {
    return hours * hourlyRate;
}

// Execute the function with an external hourlyPay function
const result4 = totalPay3(5, 1.5, 3, function() {
    return hourlyPayOuter(5, 1.5);
});
console.log("Total Pay (outer func): " + result4);

console.log("----- BONUS: Closures -----");
function makeTotalPay(hours, hourlyRate, base) {
    return function() {
      return hours * hourlyRate + base;
    };
}
const computeTotalPay = makeTotalPay(3, 1.5, 6);
const totalPayClosure = computeTotalPay();
console.log("Total Pay (closure): " + totalPayClosure);
    