#include <iostream>

struct List
{
   int data;
   List *next, *prev;
};

void create_first_object(List *&main_beg,List *&main_end, int value);
void create_list(List *&b, List *&e);
void add_to_list_from_end(List *&b, List *&e, int in);
void add_to_list_from_begin(List *&b, List *&e, int in);
void view_from_end(List *p);
void view_from_begin(List *p);
void del_all(List *&p);
void chosing_view(List *mb, List *me, List *nb, List *ne, List *pb, List *pe);
void segregation(List *main, List *&pos, List *&pos_end, List *&neg, List *&neg_end);

using namespace std;

int main()
{
    int value, size;
    char menu;
    List *main_begin = 0,*negative_begin = 0,*positive_begin = 0, *main_end = 0, *positive_end = 0, *negative_end = 0;

    while(1){
        cout <<"Chose a option: ";
        cin >> menu;
        switch (menu)
        {
        case '1':
            create_list(main_begin, main_end);
            break;
        case '2':
            segregation(main_begin,positive_begin, positive_end, negative_begin, negative_end);
            break;
        case '3':
           // add_to_list();
           break;
        case '4':
            chosing_view(main_begin, main_end, negative_begin, negative_end, positive_begin, positive_end);
            break;
        case 'e': 
            del_all(main_begin);
            del_all(negative_begin);
            del_all(positive_begin);
            cout << "Closing a program!";
            return 0;
        default:
            cout << "Entre a value between 1 and 3 or e!" << endl;
            break;
        }
    }
}

void add_to_list_from_begin(List *&begin, List *&end, int input)
{
    if(begin == 0){
        create_first_object(begin, end, input);
    }
    else{
        List *t = new List; 
        t -> data = input; 
        t -> prev = begin;
        t -> next = 0;
        begin -> next = t;
        begin = t;
    }
}

void add_to_list_from_end(List *&begin, List *&end, int input)
{
    if(begin == 0){
       create_first_object(begin, end, input);
    }
    else{
        List *t = new List; 
        t -> data = input; 
        t -> prev = 0;
        t -> next = end;
        end -> prev = t;
        end = t;
    }
}

void del_all(List *&begin) 
{
    List *t;
    while( begin != NULL) 
    {
        t = begin;
        begin = begin -> prev;
        delete t;
    }
}

void view_from_begin(List *p)
{
    cout <<"Values in list: " << endl;
    if (p == 0) 
        { 
            cout << "List is empty! " << endl;
    }else
        {
            while( p != NULL)
            {
                cout << p->data << endl;
                p = p -> prev;
            }
        }
}

void view_from_end(List *p)
{
    cout <<"Values in list: " << endl;
    if (p == 0) 
    { 
        cout << "List is empty! " << endl;
    }else
    {
        while( p != NULL)
        {
            cout << p->data << endl;
            p = p -> next;
        }
    }
}

void segregation(List *main, List *&pos_beg, List *&pos_end, List *&neg_beg, List *&neg_end)
{
    List *t = main;
    int temp;
    while (t != NULL)
    {
        temp = t -> data;
        if(temp > 0)
        {
            add_to_list_from_begin(pos_beg, pos_end, temp);
        }
            else
        {
            add_to_list_from_end(neg_beg, neg_end, temp);
        }
        t = t-> prev;
    }
}

void create_first_object(List *&main_beg,List *&main_end, int value)
{
    List *t = new List;
    t-> data = value;
    t-> next = t-> prev = 0;
    main_beg = main_end = t;
}

void chosing_view(List *mb, List *me, List *nb, List *ne, List *pb, List *pe)
{
    char menu;
    while (1)
    {
        cout << "View main list     \t - 1" << endl 
             << "View negative list \t - 2"<< endl
             << "View positive list \t - 3" <<endl
             << "View all lists     \t - 4" <<endl
             << "Return             \t - 5" <<endl
             <<"Chose your option: ";
        cin >> menu;
        switch (menu)
        {
        case '1':
            direction_selection(mb, me);
            return;
        case '2':
            direction_selection(nb, ne);
            return;
        case '3':
            direction_selection(pb, ne);
            return;
        case '4':
            direction_selection_for_all(mb, me, nb, ne, pb, pe);
            return;
        case 'e': 
            return;
        default:
            cout << "Entre 1 or 2! " << endl;
            break;
        }
    }
}

void create_list(List *&b, List *&e)
{
    if(b != 0)
    {
        cout << "List is already exist! ";
    }else
    {
        int size, value;
        cout << "Entre a size of stack: ";
        cin >> size;
        for(int i = 0; i < size; i++)
        {
            cout << "Entre a number to add it to stack: ";
            cin >> value;
            add_to_list_from_end(b, e, value);
        }
    }
}

void direction_selection(List *b, List *e)
{
    char menu;
    while (1)
    {
        cout << "View from end   \t - 1" << endl 
             << "View from begin \t - 2"<< endl
             << "Return          \t - e" <<endl
             << "Chose your option: ";
        cin >> menu;
    switch (menu)
    {
    case '1':
        view_from_end(e);
        return;
    case '2':
        view_from_begin(b);
        return;
    case 'e': 
        return;
    default:
    cout << "Entre 1, 2 or e! " << endl;
        break;
    }
    }
}

void direction_selection_for_all(List *mb, List *me, List *nb, List *ne, List *pb, List *pe)
{
    char menu;
    while (1)
    {
        cout << "View from end   \t - 1" << endl 
             << "View from begin \t - 2"<< endl
             << "Return          \t - e" <<endl
             << "Chose your option: ";
        cin >> menu;
    switch (menu)
    {
    case '1':
        view_from_end(me);
        view_from_end(pe);
        view_from_end(ne);
        return;
    case '2':
        view_from_begin(mb);
        view_from_begin(pb);
        view_from_begin(nb);
        return;
    case 'e': 
        return;
    default:
    cout << "Entre 1, 2 or e! " << endl;
        break;
    }
    }
}