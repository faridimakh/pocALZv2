kafka-topics --create --zookeeper zookeeper:2181 --topic user --replication-factor 1 --partitions 1 --config "cleanup.policy=compact" --config min.cleanable.dirty.ratio=0.001 --config segment.ms=5000

kafka-topics --bootstrap-server localhost:9092 --describe --topic user

kafka-topics --bootstrap-server localhost:9092 --delete --topic user

kafka-topics --bootstrap-server localhost:9092 --list

kafka-run-class kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic user --time -1
kafka-run-class kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic wikichangesresponses-edit --time -1
kafka-run-class kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic wikichangesresponses-log --time -1
kafka-run-class kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic wikichangesresponses-new --time -1
kafka-run-class kafka.tools.GetOffsetShell --broker-list localhost:9092 --topic wikichangesresponses-categorize --time -1




