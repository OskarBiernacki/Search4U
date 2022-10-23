# Search4U
API created to detect phishing websites

Serwer API, przyjmujący parametr w formacie JSON.
`{"url": "PODEJRZANASTRONA.pl"}`

Całość napisana w javie. Pomysłem było przeszukiwanie internetu pod kątem wzmianek o badanej stronie. Pozwoliło by to na detekcję story phishingowej przez społeczność.
Jednocześnie zachodziła by weryfikacja występujących logo na stronie, z wykorzystaniem generowanej przy starcie serwera bazy hashów pobranych z sieci log.
Ostatnią funkcjonalnością ma być przeszukiwanie samej strony w poszukiwanie podejrzanych metod płatności.


# Install

`git clone OskarBiernacki/Search4U`
Resztę można uruchomić bezproblemowo, wszystkie repos są zawarte.

# Requirements
- java
