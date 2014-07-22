# isnot.moe

Tells you when things aren't moe.

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed on your dev
machine. On your webhost you will need a copy of the JRE at v6 or above.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

	lein ring server

This will likely not be all that interesting, because localhost by
default has no subdomains. You can add some yourself in your /etc/hosts
file for testing:

	127.0.0.1 anon._isnot.moe

If you want to install it on a real website, use a jar built by:

	lein ring uberjar

## License

Copyright © 2014 Kyle McLamb, under the GPLv3.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
