from abc import ABC, abstractmethod


class ParkingSpotSubject:
    def __init__(self):
        self._observers = set()

    def attach(self, observer):
        self._observers.add(observer)

    def detach(self, observer):
        self._observers.remove(observer)

    def notify(self, parking_spot_id):
        for observer in self._observers:
            observer.update(parking_spot_id)

    # Add this method to simulate a parking spot becoming available
    def parking_spot_available(self, parking_spot_id):
        print(f"Parking spot {parking_spot_id} is now available!")
        self.notify(parking_spot_id)

class UserNotificationObserver(ParkingSpotObserver):
    def __init__(self, user_id):
        self.user_id = user_id

    def update(self, parking_spot_id):
        print(f"User {self.user_id}: Parking spot {parking_spot_id} is now available!")
        # You can implement additional notification logic here (e.g., send an actual notification)

    from abc import ABC, abstractmethod

class ParkingSpotObserver(ABC):
    @abstractmethod
    def update(self, parking_spot_id):
        pass

class ParkingSpotSubject:
    def __init__(self):
        self._observers = set()

    def attach(self, observer):
        self._observers.add(observer)

    def detach(self, observer):
        self._observers.remove(observer)

    def notify(self, parking_spot_id):
        for observer in self._observers:
            observer.update(parking_spot_id)    
# usage example    
# Create instances
subject = ParkingSpotSubject()
observer1 = UserNotificationObserver(user_id=1)
observer2 = UserNotificationObserver(user_id=2)

# Attach observers to the subject
subject.attach(observer1)
subject.attach(observer2)

# Simulate a parking spot becoming available
subject.parking_spot_available(parking_spot_id=42)

# Detach an observer (optional)
subject.detach(observer1)

# Simulate another parking spot becoming available
subject.parking_spot_available(parking_spot_id=55)
