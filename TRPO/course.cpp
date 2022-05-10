#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>
#include <cstring>
#include <vector>
#include <sha256.h>
#include <iomanip>
#include <ios>

using namespace std;

struct account
{
    string login, password, access, role;
};

struct member
{
    string surname, name, lastname, country, instrument;
    int birth_year, place;
};


const string USER_FILE = "Accounts.txt";
const string DEFAULT_USER_STRING = "admin 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 admin active";
const string MAIN_FILE = "Concert.txt";
const string DEFAULT_MAIN_FILE_STRING = "Ivanov Ivan Ivanovich 2001 Belarus piano 1";

void create_file(string FILE_NAME, string DEAFAULT_STRING);
void check_file(string FILE_NAME, string DEFAULT_STRING);

account searching_login(string login);
account authorization_and_authentication();
account access_to_system();

string input_password();


void main()
{
    char input;
    while (true)
    {
        cout << "Choose your option: ";
        input = getch();
        switch (input)
        {
        case '1':
            system("CLS");
            account user = access_to_system();
            menu(user);
            break;
        case '2':
            system("CLS");
            void registration();
            break;
        case 'e':
            return;
        default:
            system("CLS");
            break;
        }
    }  
}


    


account access_to_system()
{
    while(true)
    {
        account user = authorization_and_authentication();
        if (user.access == "denied")
        {
            cout << endl << "Access denied! Admin have to confirm this account." << endl;
            cout << left << setfill(' ') << setw(10) << "Option" << "Function" << endl;
            cout << left << setfill(' ') << setw(10) << 1 << "- try login with another account" << endl;
            cout << left << setfill(' ') << setw(10) << 2 << "- exit program" << endl;
            while (true)
            {
                char input = getch();
                if (input == '1') break;
                if (input == '2')
                {
                    account NULL_USER; 
                    NULL_USER.access = "NULL";
                    return NULL_USER;
                }
                
            }
            continue;
        }
        return user;
    }
}

void menu(account user)
{
    switch (hash_value(user.role))
    {
    case ct_hash("admin"):
        admin_menu();
        return;
    case ct_hash("viewer"):
        viewer_menu();
        return;
    default:
        return;
    }
}

void registration()
{
    check_file(USER_FILE, DEFAULT_USER_STRING);
    ifstream file("Accounts.txt");
    account user;
    string login;
    while (true)
    {
    cout << "Entre a login: ";
    cin >> login;
    while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login ) 
            {
                system("CLS");
                cout << "This login is taken!" << endl;
            }
        }
    }
}

account authorization_and_authentication()
{ 
    check_file(USER_FILE, DEFAULT_USER_STRING);
    ifstream file("Accounts.txt");
    account user;
    string login, password;
    while(true)
    {
        cout << "Entre a login: ";
        cin >> login;
        cout << "Entre a password: ";
        password = input_password();
        file.seekg(0 ,ios_base::beg);
        while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login && user.password == password) 
            {
                system("CLS");
                cout << "You entred to system!" << endl;
                return user;
            }
        }
        system("CLS");
        cout << endl << "Incorrect login or password!" << endl;
    }
}

string input_password()
{
    string pass;
    char ch;
    while(true)
    {
        ch = _getch();
        if(ch == 13)
        {
            if (pass.length() > 4) break;
            else continue;
        }
        if(ch == 8) 
        {
            if(pass.length() > 0)
            {
            cout <<"\b \b";
            pass.erase(pass.end() - 1);
            }
        }
        else 
        {
            cout << '*';
            pass.push_back(ch);
        }
    }
    return sha256(pass);
}

void check_file(string FILE_NAME, string DEFAULT_STRING)
{
    ifstream file(FILE_NAME);
    if (!file.is_open())
    {
        cout << "File doesn't exist! Standart file will be created! " << endl;
        create_file(FILE_NAME, DEFAULT_STRING);
    }
}







constexpr size_t ct_hash_suffix(char c, size_t seed)
{
    return static_cast<size_t>(c) + 0x9e3779b9ul + (seed << 6) + (seed >> 2);
}
 
size_t hash_value(string const & str)
{
    size_t seed = 0;
    for(char c : str)
    {
        seed ^= ct_hash_suffix(c, seed);
    }
    return seed;
}
 
constexpr size_t ct_hash(char const * str, size_t seed = 0)
{
    return *str ? ct_hash(str + 1, seed ^ ct_hash_suffix(*str, seed)) : seed;
}

void admin_menu()
{
    char input;
    while (true)
    {
        cout << "Choose your option: ";
        input = getch();
        switch (input)
        {
        case '1':
            system("CLS");
            view();
            break;
        case '2':
            system("CLS");
            sort();
            break;
        case '3':
            system("CLS");
            edit_member();
            break;
        case '4':
            system("CLS");
            account_activation();
            break;
        case 'e':
            system("CLS");

            return;
        default:
            system("CLS");
            break;
        }
    }
}

void viewer_menu()
{
    char input;
    while (true)
    {
        cout << "Choose your option: ";
        input = getch();
        switch (input)
        {
        case '1':
            system("CLS");
            view();
            break;
        case '2':
            system("CLS");
            sort();
            break;
        case 'e':
            system("CLS");

            return;
        default:
            system("CLS");
            break;
        }
    }
    
}

void create_file(string FILE_NAME, string DEAFAULT_STRING)
{
    ofstream file(FILE_NAME);
    file << DEAFAULT_STRING;
}

string name_input()
{
    string name;
    char ch;
    while(true)
    {
        ch = _getch();
        if(ch == 13)
        {
            if (name.length() > 4) break;
            else continue;
        }
        if(ch == 8) 
        {
            if(name.length() > 0)
            {
            cout <<"\b";
            name.erase(name.end() - 1);
            }
        }
        else 
        {
            if(ch >= )
            cout << ch;
            name.push_back(ch);
        }
    }
}