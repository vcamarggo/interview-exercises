'use strict';

//https://www.hackerrank.com/challenges/lisa-workbook/problem


const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.replace(/\s*$/, '')
        .split('\n')
        .map(str => str.replace(/\s*$/, ''));

    main();
});

function readLine() {
    return inputString[currentLine++];
}

// Complete the workbook function below.
function workbook(n, k, arr) {
    let solution = 0;
    let pag = 1;
    for(let i = 0; i < n ; i++){
        let min = 1;
        while (min <= arr[i]){
            if ( min <= pag && pag <=  Math.min((min + k - 1), arr[i])) {
                solution++
            }
            min += k;
            pag++;
        }
    }
    return solution;
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const nk = readLine().split(' ');

    const n = parseInt(nk[0], 10);

    const k = parseInt(nk[1], 10);

    const arr = readLine().split(' ').map(arrTemp => parseInt(arrTemp, 10));

    let result = workbook(n, k, arr);

    ws.write(result + "\n");

    ws.end();
}

