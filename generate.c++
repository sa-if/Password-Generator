#include <iostream>
#include <random>
#include <string>

// Returns a score indicating the strength of the given password.
// A higher score indicates a stronger password.
int score_password(const std::string& password) {
  int score = 0;

  // Increase the score for longer passwords.
  score += password.length() * 4;

  // Check for the presence of lowercase letters, uppercase letters, digits, and special characters.
  bool has_lower = false;
  bool has_upper = false;
  bool has_digit = false;
  bool has_special = false;
  for (char c : password) {
    if (std::islower(c)) {
      has_lower = true;
    } else if (std::isupper(c)) {
      has_upper = true;
    } else if (std::isdigit(c)) {
      has_digit = true;
    } else if (!std::isalnum(c)) {
      has_special = true;
    }
  }
  score += (has_lower + has_upper + has_digit + has_special) * 10;

  // Check for common patterns that might make the password easier to guess.
  // For example, "password" and "qwerty" are common patterns to avoid.
  if (password.find("password") != std::string::npos) {
    score -= 50;
  }
  if (password.find("qwerty") != std::string::npos) {
    score -= 50;
  }

  return score;
}

std::string generate_password(size_t length, const std::string& charset) {
  std::random_device rd;
  std::mt19937 generator(rd());
  std::uniform_int_distribution<int> distribution(0, charset.size() - 1);

  std::string password;
  while (true) {
    password.clear();
    for (size_t i = 0; i < length; ++i) {
      password += charset[distribution(generator)];
    }
    if (score_password(password) >= 80) {
      return password;
    }
  }
}

int main() {
  std::cout << "Enter password length: ";
  int length;
  std::cin >> length;

  std::cout << "Enter character set: ";
  std::string charset;
  std::cin >> charset;

  std::string password = generate_password(length, charset);
  std::cout << "Generated password: " << password << std::endl;
  return 0;
}
