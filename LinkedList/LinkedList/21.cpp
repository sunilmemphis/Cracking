#include <iostream>
using namespace std;

class Node {

public:
	Node *next;
	int data;

	Node() {
		next = NULL;
		data = 0;
	}
};


Node* removeDuplicates(Node* head) {
	if(head->next == NULL) 
		return head;

	Node* iter = head->next;
	Node* prevNode = head;
	bool found = false;

	while(iter != NULL) {
		found = false;
		Node* searchIter = head;
		while(searchIter != iter) {
			if(searchIter->data == iter->data) {
				found = true;
			}
			searchIter = searchIter->next;
		}
		
		if(found) {
			prevNode->next = iter->next;
		} else {
			prevNode = iter;
		}
		iter = iter->next;
	}
	return head;
}

Node* buildList() {
	Node* head = new Node();
	head->data = 0;
	Node* prevNode = head;
	
	for(int i=1;i<10;i++) {
		Node* node = new Node();
		node->data = i % 10;
		prevNode->next = node;
		prevNode = node;
	}

	return head;

}

Node* buildList(int n) {
	Node* head = new Node();
	head->data = 0;
	Node* prevNode = head;
	
	for(int i=5;i<n+5;i++) {
		Node* node = new Node();
		node->data = i % 10;
		prevNode->next = node;
		prevNode = node;
	}

	return head;
}

void printlist(Node *head) {
	cout<<" The list is ";

	while(head != NULL) {
		cout<<head->data<<"->";
		head = head->next;
	}
	cout<<"\n";
}

Node* findNthElement(Node* head,int n) {
	
	int elementNumber = 0;
	Node* head2 = head;
	while(head != NULL) {
		if(elementNumber++ > n) {
			head2 = head2->next;
		}	
		head = head->next;
	
	}
	return head2;

}

Node* addNumbers(Node* number1,Node* number2) {
	int carryOver = 0;
	Node* numberSum; 
	Node* prevNode;
	bool first = true;
	while(number1 != NULL && number2 != NULL) {
		int sum = number1->data + number2->data + carryOver;
		if(sum >= 10) {
			carryOver = 1;
			sum = sum % 10;
		} else {
			carryOver = 0;
		}

		Node* newNode = new Node();
		newNode->data = sum;
		
		if(first) {
			numberSum = newNode;
			first = false; 		
		} else {
			prevNode->next = newNode;

		}

		prevNode = newNode;
		number1 = number1->next;
		number2 = number2->next;
	}
	if(number1 == NULL) {
		number1 = number2;
	}

	while(number1 != NULL) {
		int sum = number1->data + carryOver;
		if(sum >= 10) {
			carryOver = 1;
			sum = sum%10;
		} else {
			carryOver = 0;
		}
		
		Node* newNode = new Node();
		newNode->data = sum;
		prevNode->next = newNode;
		prevNode = newNode;
		number1 = number1->next;		
	}
	return numberSum;

}

int main() {
	Node* number1 = buildList(6);
	Node* number2 = buildList(5);
	printlist(number1);
	printlist(number2);
addNumbers(number1,number2);
	cout<<"The sum is ";
	printlist(addNumbers(number1,number2));
}
