## Project Name: "Circulus Casa" (Circle Home)
Core Concept: A financial app built for familias and grupos comunitarios that combines easy money movement with the cultural value of confianza (trust) and collective support.

### Project Member:
- Jose Guevara <Jose.Guevara@my.utsa.edu>
- Daisy Montelongo <Daisy.Montelongo@my.utsa.edu>
- Sotoku Tomotsugu <Sotoku.Tomotsugu@my.utsa.edu>
- Aeden Cone <Aeden.Cone@my.utsa.edu>

### Step 1: Deepen the Problem Understanding
Key financial pain points for low-income Hispanic families/groups:
•	Pooling Money for Rent/Utilities: Multiple family members often contribute to a single household's major bills.
•	Saving for Collective Goals: Tandas (lending circles) are a common, informal practice for saving and borrowing.
•	Sending Money Home: Remittances to family in home countries are a significant expense, with high fees.
•	Lack of Banking Access: Many are unbanked or underbanked, relying on cash and money orders.
•	Language & Trust Barriers: Financial jargon in English can be a barrier, and there's a distrust of large, impersonal financial institutions.

### Step 2: User Stories for "Circulus Casa"
Primary User: Maria, a mother managing her household with her sister and two adult children living at home.
1.	As Maria, I want to create a shared "Casa" fund for our household expenses so that everyone knows what they owe for rent and utilities.
2.	As Maria's son, Carlos, I want to see the bill calendar and contribute my share easily from my phone so that I don't have to give my mom cash.
3.	As Maria's sister, Elena, I want to approve any large withdrawal from our shared savings goal so that we have confianza and accountability.
4.	As the whole family, we want to save together for a specific goal (a car, a quinceañera) in a "Meta" fund, so we can all contribute and track progress visually.
5.	As Maria, I need to send money securely to my mother in Mexico with low fees, directly from our shared fund, so she can pay for medicine.

### Step 3: Core Features & Swivel Integration
| Feature	| Swivel API / Concept Used | The "Collaboration" & Cultural Twist |
| :------- | :------: | -------: |
| Crear un Grupo (Create a Group)	| Wallets API. Create a master wallet for the "Casa" or "Meta" group.	| Name groups culturally (Casa, Familia, Tanda). Invite members via phone number. This is the foundation of collaboration. |
| Calendarario de Cuentas (Bill Calendar)	| Your app's logic. A visual calendar showing upcoming bills (rent on 1st, electricity on 15th).	| Transparent & Shared. Everyone sees the bills. The app automatically calculates each member's share. Collaboration: Members can mark their share as "paid." |
| Pagos Grupales (Group Payments)	| Payment Links API. For variable bills (like utilities), the admin creates a payment link for each person's share.	| Low-Friction Collaboration. Members pay their share directly. The app shows who has paid, creating social accountability without awkward conversations. |
| Metas (Group Savings Goals)	| Wallets API. Create a separate wallet for each goal (e.g., "Carro Usado, used cars "). | Visual Progress Bar. A powerful motivator. Shows how much has been saved towards the goal. Collaboration: Everyone can see their individual and collective progress. |
| Protección con Confianza (Trust via Co-Signing)	| Your App's Logic + Payouts API. For large withdrawals from a "Meta" savings wallet.	| This is the key collaboration feature. Require 2-of-N approvals (e.g., two family elders must approve a $200+ withdrawal). This formalizes the cultural practice of collective decision-making. |
| Envios a Casa (Remittances)	| Payouts API. Send funds from the group wallet directly to a bank account in Mexico/other countries. | Shared Responsibility. The transaction is recorded in the group's history. The cost of the remittance fee is transparent to all members. |

### Step 4: Culturally Tailored Tech & UX
This is what will make your project stand out.
•	Language First: The app should be Spanish-first, with an option for English. Don't just translate; use common, warm phrasing (e.g., "Bienvenido a la familia" instead of just "Welcome").
•	Design & Imagery: Use a warm, vibrant color palette. Use illustrations of diverse families and community gatherings, not just stock photos of money.
•	Onboarding: Explain features in the context of familiar concepts: "¿Es como una Tanda? - Sí, pero más seguro y con control." ("Is it like a Tanda? - Yes, but safer and with control.")
•	Payment Flexibility: Since many users may be unbanked, if Swivel supports it, highlight the ability to use cash-to-digital services. If not, state it as a future goal.

### Step 5: Phased Hackathon Plan for "Circulus Casa"
Phase 1: The Familia Foundation (First 8 hours)
- Set up React/Next.js frontend and Node.js backend.
- Implement Spanish-language UI and authentication.
- Build the "Crear un Grupo" flow that creates a Swivel wallet.
- Build a simple dashboard showing the group's wallet balance.
- Demo Goal: Show a user creating a "Casa" group and seeing the shared balance.

Phase 2: Transparencia y Cuentas (Transparency & Bills) (Next 8 hours)
- Build the "Calendarario de Cuentas." This is a visual winner.
- Implement the logic for splitting bills and tracking who has paid.
- Integrate Swivel Payment Links so members can pay their share.
- Demo Goal: Show a bill on the calendar, have one member pay their share via a payment link, and see the dashboard update.

Phase 3: Metas y Confianza (Goals & Trust) (Next 6 hours)
- Build the "Crear una Meta" flow (creates a separate Swivel wallet).
- Implement the visual progress bar for the savings goal.
- Implement the core collaboration feature: The 2-person approval rule for large withdrawals. Build the approval queue UI.
- Demo Goal: Show a family saving for a "Fiesta de Quinceañera." Show a withdrawal request and demonstrate that it requires two separate users to approve before the Swivel Payout is executed.

Phase 4: Polish & Story (Final 2 hours)
- Add one "wow" element, like a celebratory animation when a savings goal is met.
- Fix any critical bugs.
- Prepare your 2-minute pitch, focusing on the cultural relevance and the power of "confianza" through technology.

### The Pitch for "Circulus Casa"
Hook: "In many Hispanic households, money is a family affair. But managing it together is often stressful, informal, and based on cash. We built "Circulus Casa" to bring confianza and transparency to family finances."

### Demo Walkthrough:
1.	"Meet Maria. She creates a 'Casa' group for her family."
2.	"She adds the monthly bills to the Calendarario. Everyone sees what they owe."
3.	"Her son Carlos pays his share right from the app. No more cash under the napkin."
4.	"The family is saving for their daughter's quinceañera. They all contribute to the 'Meta' fund."
5.	"The Twist: When they need to pay the caterer, it requires both Maria and her sister to approve the payment. This is collaboration for security and trust."
6.	"This is Circulus Casa: managing money as a family, built on Swivel."

