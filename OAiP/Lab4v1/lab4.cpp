#include <iostream>
#include <string.h>
#include <math.h>
using namespace std;

struct Stack 
{
	char info;
    Stack *next;
};

Stack* add_to_stack(Stack *p, char in);
void del_all(Stack *&p);
string output(string input);
Stack* delete_element( Stack *p);
int set_prior(char a);
double operation(double value_1, double value_2, char operation);

int main()
{

    string expression;
    cout << "Entre expression: " ;
    cin >> expression;
    cout << "Your expression: " << output(expression) << endl;
    system("pause");
    return 0;
}

void del_all(Stack *&p) 
{
    Stack *t;
    while( p != NULL) 
    {
        t = p;
        p = p -> next;
        delete t;
    }
}

Stack* add_to_stack(Stack *p, char in)
{
    Stack *t = new Stack; 
    t -> info = in; 
    t -> next = p; 
    return t;
}

Stack* delete_element( Stack *p) 
{
	Stack *t = p;  			
	p = p -> next;    
	delete t;  	
   	return p;
}

string output(string input)
{
    Stack* begin = 0;
    string output;
    int prior = 0, temp = input.length();
    for(int i = 0; i < temp; i++)
    {
       if(input[i] >= 97 && input[i] <= 122)
       {
           output += input[i];
       }
       else
       {
            prior = set_prior(input[i]);
            if(input[i] == '(') begin = add_to_stack(begin, input[i]);
            if(input[i] == ')') 
            {
                while(begin -> info != '(')
                {
                    output += begin -> info;
                    begin = delete_element(begin);
                }
                begin = delete_element(begin);
            }
            while (set_prior(begin->info) >= prior)
            {
                output += begin -> info;
                begin = delete_element(begin);
            }
            begin = add_to_stack(begin, input[i]);
       } 
    }
    del_all(begin);
    return output;
}

int set_prior(char a)
{
	switch (a) 
    {
        case '^': 		    	return 4;
        case '*': 	case '/': 	return 3;
        case '-': 	case '+': 	return 2;
        case '(': 	            return 1;
    }
	return 0;
}

double operation(double value_1, double value_2, char operation)
{
    switch (operation) 
    {
        case '^':   return pow(value_1, value_2);
        case '*': 	return value_1 * value_2;
        case '/': 	return value_1 / value_2;
        case '-': 	return value_1 - value_2;
        case '+': 	return value_1 + value_2;
    }
}

