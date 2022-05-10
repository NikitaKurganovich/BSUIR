#include <iostream>
#include <fstream>
#include <conio.h>

using namespace std;

struct member
{
    string surname, name, lastname, country, instrument;
    int birth_year, place;  
};
    
string input_name();

int main ()
{
    /*
    char input;
    while (true)
    {
        input = getch();
        switch (input)
        {
        case '1':
            add_to_member_file();
            break;
        case '2':
            remove_from_member_file();
            break;
        case '3':
            sort_file();
            break;
        case '4':
            return;
            break;
        default:
            break;
        }
    }
    */
   cout << "Entre name: ";
   string name = input_name();
   cout << endl << name;
   system("pause");
   return 0;
}

void add_to_member_file()
{

}

void remove_from_member_file()
{

}

void sort_file()
{

}

bool check_uniqueness(member member)
{

}

string input_name()
{
    string name;
    char input;

    while(true)
    {
        input = getch();
        if(input == 13)
        {
            if(name.length() < 1) continue;
            else return name;
        }
        if(input == 8)
        {
            if(name.length() < 1 ) continue;
            else 
            {
                name.erase(name.end() - 1);
                cout << "\b \b";
            }
        }
        if((input >= 65 && input <= 90) || (input >= 97 && input <= 122))
        {
            cout << input;
            name.push_back(input);
        }
    }
}
