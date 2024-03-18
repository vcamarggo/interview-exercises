//https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem

'use strict';

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

const SinglyLinkedListNode = class {
    constructor(nodeData) {
        this.data = nodeData;
        this.next = null;
    }
};

const SinglyLinkedList = class {
    constructor() {
        this.head = null;
        this.tail = null;
    }

    insertNode(nodeData) {
        const node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
};

function printSinglyLinkedList(node, sep, ws) {
    while (node != null) {
        ws.write(String(node.data));

        node = node.next;

        if (node != null) {
            ws.write(sep);
        }
    }
}

// Complete the mergeLists function below.

/*
 * For your reference:
 *
 * SinglyLinkedListNode {
 *     int data;
 *     SinglyLinkedListNode next;
 * }
 *
 */
function mergeLists(l1, l2) {

    let head = new SinglyLinkedListNode();

    if (l1) {
        if (!l2 || l2 && l1.data <= l2.data) {
            head = new SinglyLinkedListNode(l1.data);
            l1 = l1.next
        } else {
            head = new SinglyLinkedListNode(l2.data);
            l2 = l2.next
        }
    } else if (l2) {
        if (!l1 || l1 && l1.data <= l2.data) {
            head = new SinglyLinkedListNode(l1.data);
            l1 = l1.next
        } else {
            head = new SinglyLinkedListNode(l2.data);
            l2 = l2.next
        }
    }

    let current = head;

    while (l1 || l2) {

        if (l1) {
            if (!l2 || l2 && l1.data <= l2.data) {
                current.next = new SinglyLinkedListNode(l1.data);
                l1 = l1.next
                current = current.next
            } else {
                current.next = new SinglyLinkedListNode(l2.data);
                l2 = l2.next
                current = current.next
            }
        } else if (l2) {
            if (!l1 || l1 && l2.data <= l1.data) {
                current.next = new SinglyLinkedListNode(l2.data);
                l2 = l2.next
                current = current.next
            } else {
                current.next = new SinglyLinkedListNode(l1.data);
                l1 = l1.next
                current = current.next
            }
        }

    }
    return head;

}

function main() {
}
