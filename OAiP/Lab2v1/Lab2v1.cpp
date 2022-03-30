#include <iostream>

struct Stack
{
   int data;
   Stack *next;
};

Stack* add_to_stack(Stack *p, int in);
void View(Stack *p);
void del_all(Stack *&p);
void segregation(Stack *main,Stack *&pos, Stack *&neg);

using namespace std;

int main()
{
    int value, size;
    Stack *begin = 0,*negative = 0,*positive = 0;
    cout << "Entre a size of stack: ";
    cin >> size;

    for(int i = 0; i < size; i++)
    {
        cout << "Entre a number to add it to stack: ";
        cin >> value;
        begin = add_to_stack(begin, value);
    }

    View(begin);
    segregation(begin,positive,negative);

    View(positive);
    View(negative);
    
    del_all(begin);
    del_all(negative);
    del_all(positive);
return 0;
}

Stack* add_to_stack(Stack *p, int in)
{
    Stack *t = new Stack; 
    t -> data = in; 
    t -> next = p; 
    return t;
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

void View(Stack *p)
{
    cout <<"Values in stack: " << endl;
    Stack *t = p;
    if (t == 0) 
    { 
        cout << "Stack is empty! " << endl;
    }else
    {
        while( t != NULL)
        {
            cout << t->data << endl;
            t = t -> next;
        }
    }
    delete t;
}

void segregation(Stack *main, Stack *&pos, Stack *&neg)
{
    Stack *t = main;
    int temp;
    while (t != NULL)
    {
        temp = t ->data;
        if(temp > 0)
        {
            pos = add_to_stack(pos, temp);
        }
            else
        {
            neg = add_to_stack(neg, temp);
        }
        t = t-> next;
    }
}