class Node {
	constructor(value) {
		this.value = value;
		this.next = null;
	}
}

class SinglyLinkedList {
	constructor() {
		this.head = null;
		this.tail = null;
	}

	find(value) {
		let currentNode = this.head;
		while (currentNode !== null && currentNode.value !== value) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

	append(newValue) {
		const newNode = new Node(newValue);
		if (this.head === null) {
			this.head = newNode;
			this.tail = newNode;
		} else {
			this.tail.next = newNode;
			this.tail = newNode;
		}
	}

	insert(node, newValue) {
		const newNode = new Node(newValue);
		newNode.next = node.next;
		node.vext = newNode;
	}

	remove(value) {
		let preNode = this.head;
		while (preNode.next.value !== value) {
			preNode = preNode.next;
		}
		if (preNode.next !== null) {
			preNode.next = preNode.next.next;
		}
	}
	display() {
		let currentNode = this.head;
		let displayContent = '';
		while (currentNode !== null) {
			displayContent += `${currentNode.value},`;
			currentNode = currentNode.next;
		}
		displayContent = '[' + displayContent + ']';
		console.log(displayContent);
	}
}

const linkedList = new SinglyLinkedList();
linkedList.append(1);
linkedList.append(3);
linkedList.append(5);
linkedList.append(7);
console.log(linkedList.find(3));
linkedList.display();
