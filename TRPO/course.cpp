#include <iostream>
#include <fstream>
#include <string>
#include <conio.h>
#include <cstring>
#include <vector>
#include <sha256.h>

using namespace std;

struct account
{
    string login, password, access, role;
};


const string USER_FILE = "Acconts.txt";
const string DEFAULT_USER_STRING = "admin 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918 admin active";

void create_file(string FILE_NAME, string DEAFAULT_STRING);
void check_file(string FILE_NAME, string DEFAULT_STRING);

account searching_login(string login);
account authorization_and_authentication();
account access_to_system();

string input_password();


int main()
{
    
    
    return 0;
}

void create_file(string FILE_NAME, string DEAFAULT_STRING)
{
    ofstream file(FILE_NAME);
    file << DEAFAULT_STRING;
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
        while(!file.eof())
        {
            user.login = user.password = user.role = user.access = "";
            file >> user.login >> user.password >> user.role >> user.access;
            if (user.login == login && user.password == password) return user;
        }
        cout << "Incorrect login or password!" << endl;
    }
}

string input_password()
{
    string pass;
    char ch;
    while(true)
    {
        ch = _getch();
        if(ch == 13) break;
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

void task(account user)
{


}

account access_to_system()
{
    while(true)
    {
        account user = authorization_and_authentication();
        if (user.access == "denied")
        {
        cout << "Access denied! Admin have to confirm your account. Press any button to return" << endl;
        continue;
        }
        return user;
    }
}

