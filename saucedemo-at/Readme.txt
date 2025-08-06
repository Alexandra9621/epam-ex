Solid principles for Login Page

Single Responsibility Principle
No SRP violations. Responsibilities are clearly defined and separated
between the core functionality (LoginPage) and the extended functionality (LoggingLoginPageDecorator).

Open/Closed Principle
No OCP violations. The design supports extension without modifying existing code.

Liskov Substitution Principle (LSP)
LoginPage Compliance:
Any class derived from AbstractPageFactory (like LoginPage) can be substituted wherever an
AbstractPageFactory is expected, without altering program behavior.

LoggingLoginPageDecorator Compliance:
The decorator class LoggingLoginPageDecorator is a subclass of LoginPage.
It overrides the original methods while respecting their behavior. For example:
openPage(String url) still navigates to the given URL but adds logging.
login(User user) still performs the login logic but adds logging to document the process.
When substituted for a normal LoginPage, the decorator behaves as expected and fulfills its promises.
No LSP violations. Substitutions work seamlessly without breaking expected behavior.

Interface Segregation Principle
LoginPage Compliance:
The methods in LoginPage (enterUsername(), enterPassword(), clickLoginButton(), etc.)
focus solely on login-related interactions. The class does not implement any unrelated functionality,
keeping its interface clean and focused.

Decorator Compliance:
The LoggingLoginPageDecorator adds functionality specific to LoginPage behavior (e.g., logging, method chaining).
It does not implement unrelated functionalities,ensuring its interface remains cohesive and narrowly scoped.
No ISP violations. Both classes focus on narrowly scoped responsibilities.

Dependency Inversion Principle (DIP)
I introduced an interface for 'LoginPageImpl' (LoginPage) to decouple the decorator logic further.
One could argue that the decorator logic tightly couples LoggingLoginPageDecorator to the
LoginPage implementation, rather than relying on an abstraction (e.g., making LoginPage implement an
 interface like ILoginPage). While this is not strictly a violation, introducing interfaces can make
 the design more flexible.


Solid Principle for Dashboard Page

Single Responsibility principle
Problem: dashboard page has multiple responsabilities:
It interacts with dashboard-specific UI elements (e.g., title and buttons).
It performs cart management operations (e.g., adding/removing items, navigating to the cart, and checkout).
It provides logging functionality for some actions (adding items, removing items).
Solution:
Adding items to the cart could be encapsulated in a Cart Management Service class.
Checkout-related actions could be handled in a CheckoutPage or CheckoutService.
This separation would simplify the DashboardPage's management and allow responsibilities to evolve independently.

Open/closed Principle
Problem:
If additional cart items need to be added (e.g., new product IDs), the addItemsToCart() method in the
DashboardPage would need to be modified directly to include interaction with the new web elements associated
with these items.
The removeItems() method also hardcodes specific product removal logic. If more items need to be removed or
the logic changes (e.g., dynamically removing items), this method would need constant modification.
Solution:
Replace hardcoded interaction with dynamically located elements. For example, instead of relying on
specific product @FindBy elements like backPackItem, use more generic locators to dynamically add or remove
items by their name, ID, or metadata.

Liskov Substitution Principles
No LSP violation is noted in the current implementation.

