console.log("---- Part 1: Conditionals ----");
console.log("--> First Try");
let age = 19;

if (age === 19) {
    console.log("Equal to the number");
}

if (age == "19") { // Using '==' to allow type coercion
    console.log("Equal to the string");
}

if (age) { // Checks for truthy value
    console.log("Truthy!");
}

console.log("--> Second Try");

age = 0;

if (age === 19) {
    console.log("Equal to the number");
}

if (age == "19") {
    console.log("Equal to the string");
}

if (age) {
    console.log("Truthy!");
}

console.log("---- Part 2: Arrays and Iteration ----");
const classes = ["COSC 2328", "COSC 2329", "MATH 1010"]; 
const days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
classes.forEach((course) => {
    console.log(course);
});
days.forEach((day, index) => {
    console.log(`${day} (${index})`);
});
days.forEach((day) => {
    console.log(day);
    classes.forEach((course) => {
        console.log(course);
    });
});
console.log("---- Part 3: Objects ----");
const myself = {
    firstName: "Rifat Abrar",
    lastName: "Jowad",
    graduationYear: 2027,
    hobbies: ["Gaming", "Climbing"],
    schoolAddress: {
        schoolName: "St. Edward’s University",
        streetAddress: "3001 S Congress Ave",
        city: "Austin",
        state: "TX"
    }
};
console.log(`${myself.firstName} ${myself.lastName} graduates in ${myself.graduationYear} from ${myself.schoolAddress.schoolName} at ${myself.schoolAddress.streetAddress}, ${myself.schoolAddress.city}, ${myself.schoolAddress.state}`);
console.log(`${myself.firstName}'s Hobbies:`);
myself.hobbies.forEach((hobby) => {
    console.log(`- ${hobby}`);
});
console.log("---- Part 4: BONUS ----");
const mwfClasses = ["COSC 2328", "ENGR 1010"]; 
const tthClasses = ["MATH 1010", "PHYS 2020"]; 
const schedule = [
    { day: "Monday", classes: mwfClasses },
    { day: "Tuesday", classes: tthClasses },
    { day: "Wednesday", classes: mwfClasses },
    { day: "Thursday", classes: tthClasses },
    { day: "Friday", classes: mwfClasses }
];
console.log("My Schedule:");
schedule.forEach((entry) => {
    console.log(entry.day);
    entry.classes.forEach((course) => {
        console.log(course);
    });
});
